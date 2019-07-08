package win.regin.base.exception

import java.net.ConnectException
import java.net.UnknownHostException

/**
 * @author :Reginer in  2019/7/8 9:41.
 *         联系方式:QQ:282921012
 *         功能描述:错误
 */

class HubException : Exception {
    var errorMsg: String? = null

    constructor(error: String?) : super(error) {
        errorMsg = error
    }

    constructor(throwable: Throwable?) : super(throwable) {
        errorMsg = parseError(throwable)
    }

    private fun parseError(throwable: Throwable?): String {
        return when (throwable) {
            is ConnectException -> "网络错误"
            is UnknownHostException -> "无网络连接"
            else -> "其他错误"
        }
    }
}