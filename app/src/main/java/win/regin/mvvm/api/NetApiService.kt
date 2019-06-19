package win.regin.mvvm.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import win.regin.common.database.UserEntity
import win.regin.mvvm.model.Urls
import win.regin.mvvm.model.BaseEntity

/**
 * @author :Reginer in  2019/6/18 21:29.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
interface NetApiService {
    @POST(Urls.LOGIN)
    @FormUrlEncoded
    suspend fun login(@Field("username") username: String?, @Field("password") password: String?): BaseEntity<UserEntity>
}