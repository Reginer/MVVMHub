package win.regin.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import win.regin.common.database.DaoManager
import win.regin.common.database.UserEntity

/**
 * @author :Reginer in  19-6-19 下午5:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainRepository {
    fun getLoginUser(): LiveData<UserEntity?> {
        val userLiveData = DaoManager.getInstance().daoOptions.getAllUserLiveData()
        return Transformations.map(userLiveData) {
            if (it.isNotEmpty()) it.first() else null
        }
    }
}