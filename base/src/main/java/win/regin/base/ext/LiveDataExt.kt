package win.regin.base.ext

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import win.regin.base.state.VmState

/**
 * @author :Reginer in  2020/6/29 16:41.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@MainThread
inline fun <T> LiveData<T>.observe(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<T> {
    val wrappedObserver = Observer<T> { t -> onChanged.invoke(t) }
    observe(owner, wrappedObserver)
    return wrappedObserver
}
typealias VmLiveData<T> = MutableLiveData<VmState<T>>