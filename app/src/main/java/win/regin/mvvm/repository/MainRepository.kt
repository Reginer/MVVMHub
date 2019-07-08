package win.regin.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import io.objectbox.android.ObjectBoxLiveData
import win.regin.common.database.ArticleEntity
import win.regin.common.database.BoxOptions
import win.regin.common.database.UserEntity
import win.regin.common.entity.BaseEntity
import win.regin.mvvm.api.NetworkApi

/**
 * @author :Reginer in  19-6-19 下午5:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainRepository {
    fun getLoginUser(): LiveData<UserEntity?> {
        val userLiveData = ObjectBoxLiveData(BoxOptions.getAllUserLiveData())
        return Transformations.map(userLiveData) {
            if (it.isNotEmpty()) it.first() else null
        }
    }

    fun parseArticleData(pageLiveData: MutableLiveData<Long>, data: ArticleEntity) {
        BoxOptions.insertArticle(data)
        pageLiveData.postValue(data.curPage)
    }

    suspend fun getArticle(page: Long): BaseEntity<ArticleEntity> {
        return NetworkApi.getApi().getArticle(page)
    }


}