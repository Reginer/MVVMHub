package win.regin.common.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * @author :Reginer in  19-6-19 下午5:05.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class DaoOptions : IDaoOptions {
    override suspend fun getAllUser(): List<UserEntity>? {
        return DaoManager.getInstance().dao.userDao.getAllUser()
    }

    override fun getAllUserLiveData(): LiveData<List<UserEntity>> {
        return DaoManager.getInstance().dao.userDao.getAll()

    }

    override suspend fun insertUser(userEntity: UserEntity) {
        withContext(Dispatchers.IO) {
            DaoManager.getInstance().dao.userDao.insert(userEntity)
        }
    }

    override suspend fun deleteAllUser() {
        withContext(Dispatchers.IO) {
            DaoManager.getInstance().dao.userDao.deleteAll()
        }
    }


}