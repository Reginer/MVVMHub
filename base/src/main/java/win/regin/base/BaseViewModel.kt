package win.regin.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import win.regin.common.entity.BaseEntity
import win.regin.base.state.ViewState
import win.regin.base.state.paresException
import win.regin.base.state.paresResult

/**
 * @author :Reginer in  19-6-18 下午6:03.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
open class BaseViewModel : ViewModel() {
    fun <T> launchWork(block: BaseEntity<T>, viewState: MutableLiveData<ViewState<T>>) {
        viewState.value = ViewState.onHubLoading()
        runCatching {
            block
        }.onSuccess {
            viewState.paresResult(it)
        }.onFailure {
            viewState.paresException(it)
        }
    }

}
