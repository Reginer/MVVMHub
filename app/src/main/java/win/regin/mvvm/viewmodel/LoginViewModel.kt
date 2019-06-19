package win.regin.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.common.utils.Logcat
import win.regin.mvvm.model.BaseEntity
import win.regin.mvvm.model.UserEntity
import win.regin.mvvm.repository.LoginRepository

/**
 * @author :Reginer in  2019/6/18 21:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginViewModel : BaseViewModel() {
    private val loginRepository = LoginRepository()

    val loginResult: MutableLiveData<BaseEntity<UserEntity>> = MutableLiveData()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            runCatching {
                loginRepository.login(username, password)
            }.onSuccess {
                Logcat.d(it.toString())
            }.onFailure {
                Logcat.e(Log.getStackTraceString(it))
            }
        }
    }
}