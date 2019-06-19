package win.regin.mvvm.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import win.regin.mvvm.model.Urls

/**
 * @author :Reginer in  2019/6/18 20:49.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
object NetworkApi {
    fun getApi(): NetApiService {
        return Retrofit.Builder().baseUrl(Urls.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(getOkHttpClient()).build().create(
                NetApiService::class.java
            )
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply { addInterceptor(LogInterceptor()) }.build()
    }

}



