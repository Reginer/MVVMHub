package win.regin.common.database

import androidx.lifecycle.LiveData

/**
 * @author :Reginer in  19-6-19 下午5:02.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
interface IDaoOptions {
    fun getAllUserLiveData(): LiveData<List<UserEntity>>

    suspend fun getAllUser(): List<UserEntity>?

    suspend fun insertUser(userEntity: UserEntity)

    suspend fun deleteAllUser()
}