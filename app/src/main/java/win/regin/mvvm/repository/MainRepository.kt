package win.regin.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import io.objectbox.android.ObjectBoxLiveData
import win.regin.mvvm.api.NetworkApi
import win.regin.mvvm.data.AppBaseEntity
import win.regin.mvvm.data.ArticleEntity
import win.regin.mvvm.data.BoxOptions
import win.regin.mvvm.data.UserEntity

/**
 * @author :Reginer in  19-6-19 下午5:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainRepository {
    fun getLoginUser(): LiveData<UserEntity?> {
        val userLiveData = ObjectBoxLiveData(BoxOptions.getAllUserLiveData())
        return userLiveData.map { if (it.isNotEmpty()) it.first() else null  }
    }

    fun parseArticleData(pageLiveData: MutableLiveData<Long>, data: ArticleEntity) {
        BoxOptions.insertArticle(data)
        pageLiveData.postValue(data.curPage)
    }

    suspend fun getArticle(page: Long): AppBaseEntity<ArticleEntity> {
        return NetworkApi.getApi().getArticle(page)
    }


}