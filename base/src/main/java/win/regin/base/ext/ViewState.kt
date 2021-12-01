package win.regin.base.ext

import win.regin.base.exception.AppException

/**
 * @author :Reginer in  2019/7/8 9:42.
 *         联系方式:QQ:282921012
 *         功能描述:
 */


class VmResult<T> {
    var onAppSuccess: (data: T) -> Unit = {}
    var onAppError: (AppException) -> Unit = {}
    var onAppLoading: () -> Unit = {}
    var onAppComplete: () -> Unit = {}
}

sealed class VmState<out T> {
    object Loading : VmState<Nothing>()
    data class Success<out T>(val data: T) : VmState<T>()
    data class Error(val error: AppException) : VmState<Nothing>()
}
