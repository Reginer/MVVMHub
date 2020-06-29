package win.regin.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import win.regin.base.BaseViewModel
import win.regin.base.ext.VmLiveData
import win.regin.base.ext.launchVmRequest
import win.regin.mvvm.data.UserEntity
import win.regin.mvvm.repository.LoginRepository

/**
 * @author :Reginer in  2019/6/18 21:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginViewModel : BaseViewModel() {
    private val loginRepository by lazy { LoginRepository() }
    val loginResult: VmLiveData<UserEntity> = MutableLiveData()

    fun login(username: String, password: String) {
        launchVmRequest({ loginRepository.login(username, password) }, loginResult)
    }

    fun saveUser(userEntity: UserEntity) {
        loginRepository.insertUser(userEntity)
    }
}