package win.regin.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.ext.paresException
import win.regin.base.ext.paresResult
import win.regin.base.state.ViewState
import win.regin.common.entity.BaseEntity

/**
 * @author :Reginer in  19-6-18 下午6:03.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
open class BaseViewModel : ViewModel() {
    /**
     * net request
     * @param request request method
     * @param viewState request result
     */
    fun <T> launchRequest(request: suspend () -> BaseEntity<T>, viewState: MutableLiveData<ViewState<T>>) {
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
}
