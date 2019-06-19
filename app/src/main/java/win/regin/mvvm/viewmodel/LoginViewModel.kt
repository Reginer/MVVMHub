package win.regin.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.common.database.DaoManager
import win.regin.common.database.UserEntity
import win.regin.common.utils.Logcat
import win.regin.mvvm.model.BaseEntity
import win.regin.mvvm.repository.LoginRepository

/**
 * @author :Reginer in  2019/6/18 21:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginViewModel : BaseViewModel() {
    private val loginRepository = LoginRepository()

    private val loginLiveData: MutableLiveData<BaseEntity<UserEntity>> = MutableLiveData()
    val loginResult: LiveData<UserEntity?> = Transformations.map(loginLiveData) {
        if (it.errorCode == 0) {
            saveUser(it.data)
            it.data
        } else {
            null
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            runCatching {
                loginRepository.login(username, password)
            }.onSuccess {
                loginLiveData.postValue(it)
            }.onFailure {
                Logcat.e(Log.getStackTraceString(it))
            }
        }
    }

    private fun saveUser(userEntity: UserEntity) {
        viewModelScope.launch {
            runCatching {
                loginRepository.insertUser(userEntity)
            }
        }
    }
}