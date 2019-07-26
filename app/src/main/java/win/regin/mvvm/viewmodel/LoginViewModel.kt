package win.regin.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.base.ext.parseResult
import win.regin.common.database.UserEntity
import win.regin.base.state.ViewState
import win.regin.mvvm.repository.LoginRepository

/**
 * @author :Reginer in  2019/6/18 21:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginViewModel : BaseViewModel() {
    private val loginRepository by lazy { LoginRepository() }
    val loginResult: MutableLiveData<ViewState<UserEntity>> = MutableLiveData()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            runCatching {
                loginResult.value = ViewState.onHubLoading()
                loginRepository.login(username, password)
            }.parseResult(loginResult)
        }

    }

    fun saveUser(userEntity: UserEntity) {
        loginRepository.insertUser(userEntity)
    }
}