package win.regin.base.ext

import win.regin.base.BaseVmActivity
import win.regin.base.exception.HubException
import win.regin.base.state.ViewState
import java.lang.reflect.ParameterizedType

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
            dismissProgress(null)
            onSuccess(viewState.data)
        }
        is ViewState.Error -> {
            dismissProgress(viewState.error)
            onError?.run { this(viewState.error) }
        }
    }
}