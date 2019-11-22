package win.regin.mvvm.repository

import win.regin.mvvm.api.NetworkApi
import win.regin.mvvm.data.AppBaseEntity
import win.regin.mvvm.data.BoxOptions
import win.regin.mvvm.data.UserEntity

/**
 * @author :Reginer in  2019/6/18 21:33.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginRepository {
    suspend fun login(username: String, password: String): AppBaseEntity<UserEntity> {
        return NetworkApi.getApi().login(username, password)
    }

    fun insertUser(userEntity: UserEntity) {
        BoxOptions.deleteAllUser()
        BoxOptions.insertUser(userEntity)
    }
}