package win.regin.base.ext

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.base.BaseVmActivity
import win.regin.base.BaseVmFragment
import win.regin.base.R
import win.regin.base.exception.AppException
import win.regin.base.state.ViewState
import win.regin.base.state.VmResult
import win.regin.base.state.VmState
import win.regin.common.AppCommon
import win.regin.common.BaseEntity
import java.lang.reflect.ParameterizedType
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * @author :Reginer in  19-6-18 下午6:04.
 * 联系方式:QQ:282921012
 * 功能描述:
 */


/**
 * 获取vm clazz
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}


/**
 * 显示页面状态，这里有个技巧，成功回调在第一个，其后两个带默认值的回调可省
 * @param viewState 接口返回值
 * @param onLoading 加载中
 * @param onSuccess 成功回调
 * @param onError 失败回调
 *
 */
fun <T> BaseVmActivity<*>.parseState(
    viewState: ViewState<T>,
    onSuccess: (T) -> Unit,
    onError: ((AppException) -> Unit)? = null,
    onLoading: (() -> Unit)? = null
) {
    when (viewState) {
        is ViewState.Loading -> {
            showProgress()
            onLoading?.run { this }
        }
        is ViewState.Success -> {
            dismissProgress()
            onSuccess(viewState.data)
        }
        is ViewState.Error -> {
            dismissProgress()
            onError?.run { this(viewState.error) }
        }
    }
}

fun <T> BaseVmFragment<*>.parseState(
    viewState: ViewState<T>,
    onSuccess: (T) -> Unit,
    onError: ((AppException) -> Unit)? = null,
    onLoading: (() -> Unit)? = null
) {
    (activity as? BaseVmActivity<*>)?.parseState(viewState, onSuccess, onError, onLoading)
}

/**
 *我想了一东的时间，错误提示需要改一下
 */
fun Throwable?.parseErrorString(): String {
    return when (this) {
        is ConnectException -> AppCommon.instance.getString(R.string.ConnectException)
        is UnknownHostException -> AppCommon.instance.getString(R.string.UnknownHostException)
        else -> AppCommon.instance.getString(R.string.ElseNetException)
    }
}


@MainThread
inline fun <T> VmLiveData<T>.vmObserver(owner: LifecycleOwner, vmResult: VmResult<T>.() -> Unit) {
    val result = VmResult<T>();result.vmResult();observe(owner) {
        when (it) {
            is VmState.Loading ->{
                result.onAppLoading()
            }
            is VmState.Success -> {
                result.onAppSuccess(it.data);result.onAppComplete()
            }
            is VmState.Error -> {
                result.onAppError(it.error);result.onAppComplete()
            }
        }
    }
}

/**
 * net request
 * @param request request method
 * @param viewState request result
 * @param showLoading 配置是否显示等待框
 */
@Deprecated("回调麻烦了点", ReplaceWith(expression = "launchVmRequest"))
fun <T> BaseViewModel.launchRequest(
    request: suspend () -> BaseEntity<T>,
    viewState: MutableLiveData<ViewState<T>>,
    showLoading: Boolean = true
) {
    viewModelScope.launch {
        runCatching {
            if (showLoading) viewState.value = ViewState.onAppLoading()
            request()
        }.onSuccess {
            viewState.paresResult(it)
        }.onFailure {
            viewState.paresException(it)
        }
    }
}

/**
 * net request
 * @param request request method
 * @param viewState request result
 */
fun <T> BaseViewModel.launchVmRequest(
    request: suspend () -> BaseEntity<T>,
    viewState: VmLiveData<T>
) {
    viewModelScope.launch {
        runCatching {
            viewState.value = VmState.Loading
            request()
        }.onSuccess {
            viewState.paresVmResult(it)
        }.onFailure {
            viewState.paresVmException(it)
        }
    }
}

/**
 * net request
 * @param request request method
 */
fun <T> BaseViewModel.launchRequestNoState(
    request: suspend () -> BaseEntity<T>
) {
    viewModelScope.launch {
        runCatching {
            request()
        }
    }
}


/**
 * 以协程形式执行
 */
fun BaseViewModel.launchBlock(block: () -> Unit) {
    viewModelScope.launch { block() }
}
