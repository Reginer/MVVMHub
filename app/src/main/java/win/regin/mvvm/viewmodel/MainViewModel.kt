package win.regin.mvvm.viewmodel

import androidx.lifecycle.LiveData
import win.regin.base.BaseViewModel
import win.regin.common.database.UserEntity
import win.regin.mvvm.repository.MainRepository

/**
 * @author :Reginer in  19-6-19 下午5:56.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainViewModel : BaseViewModel() {
    private val mainRepository = MainRepository()
    val userLiveData: LiveData<UserEntity?> = mainRepository.getLoginUser()

}
