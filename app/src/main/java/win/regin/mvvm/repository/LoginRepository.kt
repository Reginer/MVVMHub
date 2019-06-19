package win.regin.mvvm.repository

import win.regin.common.database.DaoManager
import win.regin.common.database.UserEntity
import win.regin.mvvm.api.NetworkApi
import win.regin.mvvm.model.BaseEntity

/**
 * @author :Reginer in  2019/6/18 21:33.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginRepository {
    suspend fun login(username: String, password: String): BaseEntity<UserEntity> {
        return NetworkApi.getApi().login(username, password)
    }

    suspend fun insertUser(userEntity: UserEntity) {
        DaoManager.getInstance().daoOptions.deleteAllUser()
        DaoManager.getInstance().daoOptions.insertUser(userEntity)
    }
}