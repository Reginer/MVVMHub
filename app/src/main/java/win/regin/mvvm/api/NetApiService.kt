package win.regin.mvvm.api

import retrofit2.http.*
import win.regin.mvvm.data.ArticleEntity
import win.regin.mvvm.data.UserEntity
import win.regin.mvvm.data.AppBaseEntity
import win.regin.mvvm.model.Urls

/**
 * @author :Reginer in  2019/6/18 21:29.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
interface NetApiService {
    @POST(Urls.LOGIN)
    @FormUrlEncoded
    suspend fun login(@Field("username") username: String, @Field("password") password: String): AppBaseEntity<UserEntity>

    @GET(Urls.ARTICLE)
    suspend fun getArticle(@Path("page") page: Long): AppBaseEntity<ArticleEntity>
}