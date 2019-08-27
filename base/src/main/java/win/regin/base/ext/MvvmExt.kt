package win.regin.base.ext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.base.BaseVmActivity
import win.regin.base.R
import win.regin.base.exception.HubException
import win.regin.base.state.ViewState
import win.regin.common.AppCommon
import win.regin.common.entity.BaseEntity
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
 * 显示页面状态
 * @param viewState 接口返回值
 * @param onLoading 加载中
 * @param onSuccess 成功回调
 * @param onError 失败回调
 *
 */
fun <T> BaseVmActivity<*>.parseState(
    viewState: ViewState<T>,
    onSuccess: (T) -> Unit,
    onError: ((HubException) -> Unit)? = null,
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

/**
 * net request
 * @param request request method
 * @param viewState request result
 */
fun <T> BaseViewModel.launchRequest(request: suspend () -> BaseEntity<T>, viewState: MutableLiveData<ViewState<T>>) {
    viewModelScope.launch {
        runCatching {
            viewState.value = ViewState.onHubLoading()
            request()
        }.onSuccess {
            viewState.paresResult(it)
        }.onFailure {
            viewState.paresException(it)
        }
    }
}
