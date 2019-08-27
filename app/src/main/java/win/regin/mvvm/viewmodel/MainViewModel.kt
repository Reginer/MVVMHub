package win.regin.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import io.objectbox.android.ObjectBoxLiveData
import win.regin.base.BaseViewModel
import win.regin.base.ext.launchRequest
import win.regin.base.state.ViewState
import win.regin.common.database.ArticleEntity
import win.regin.common.database.BoxOptions
import win.regin.common.database.UserEntity
import win.regin.common.entity.ArticleDataEntity
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
    val articleResult: MutableLiveData<ViewState<ArticleEntity>> = MutableLiveData()
    val articleLiveData: LiveData<List<ArticleDataEntity>?> =
        Transformations.switchMap(pageLiveData) { page ->
            Transformations.map(ObjectBoxLiveData(BoxOptions.queryArticle())) {
                it.find { articleEntity -> articleEntity.curPage <= page }?.articleList
            }
        }

    fun parseArticleData(data: ArticleEntity) {
        mainRepository.parseArticleData(pageLiveData, data)
    }


    fun getArticle(curPage: Long) {
        launchRequest({ mainRepository.getArticle(curPage) }, articleResult)
    }
}
