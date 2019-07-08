package win.regin.base.state

import androidx.lifecycle.MutableLiveData
import win.regin.common.entity.BaseEntity
import win.regin.base.exception.HubException

/**
 * @author :Reginer in  2019/7/8 10:47.
 *         联系方式:QQ:282921012
 *         功能描述:
 */

/**
 * 处理返回值
 *
 * @param result 请求结果
 */
fun <T> MutableLiveData<ViewState<T>>.paresResult(result: BaseEntity<T>) {
    when (result.errorCode) {
        0 -> this.value = ViewState.onHubSuccess(result.data)
        else -> this.value = ViewState.onHubError(HubException(result.errorMsg))
    }
}

/**
 * 异常转换异常处理
 *
 * @param e 错误信息
 */
fun <T> MutableLiveData<ViewState<T>>.paresException(e: Throwable) {
    this.value = ViewState.onHubError(HubException(e))
}