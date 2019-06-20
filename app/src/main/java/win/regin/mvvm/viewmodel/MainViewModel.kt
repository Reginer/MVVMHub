package win.regin.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.launch
import win.regin.base.BaseViewModel
import win.regin.common.database.BoxOptions
import win.regin.common.database.UserEntity
import win.regin.common.entity.ArticleDataEntity
import win.regin.common.utils.Logcat
import win.regin.mvvm.repository.MainRepository

/**
 * @author :Reginer in  19-6-19 下午5:56.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainViewModel : BaseViewModel() {
    private val mainRepository by lazy { MainRepository() }
    val userLiveData: LiveData<UserEntity?> by lazy { mainRepository.getLoginUser() }
    val pageLiveData: MutableLiveData<Long> by lazy { MutableLiveData<Long>() }
    val articleLiveData: LiveData<List<ArticleDataEntity>?> = Transformations.switchMap(pageLiveData) { page ->
        Transformations.map(ObjectBoxLiveData(BoxOptions.queryArticle())) {
            it.find { articleEntity -> articleEntity.curPage <= page  }?.articleList
        }
    }


    fun getArticle(curPage: Long) {
        viewModelScope.launch {
            runCatching {
                mainRepository.getArticle(curPage)
            }.onSuccess {
                mainRepository.parseArticleData(pageLiveData, it)
            }.onFailure {
                Logcat.e(Log.getStackTraceString(it))
            }
        }
    }
}
