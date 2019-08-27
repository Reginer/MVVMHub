package win.regin.mvvm.api

import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import win.regin.mvvm.BuildConfig
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
            .client(getOkHttpClient()).build().create(NetApiService::class.java)
    }

    /**
     * 配置http
     */
    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(getInterceptor())
        }.build()
    }

    /**
     * 配置拦截器
     */
    private fun getInterceptor(): Interceptor {
        val rLog = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Logger.i(message)
            }
        }
        return HttpLoggingInterceptor(rLog).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}



