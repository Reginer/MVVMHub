package win.regin.common

import com.google.gson.Gson
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * @author :Reginer in  2019/7/27 11:20.
 *         联系方式:QQ:282921012
 *         功能描述:日志扩展类
 */


/**
 * 设置是否打印和打印tag
 */
fun String.logTagDebug(debug: Boolean): AndroidLogAdapter {
    val formatStrategy = PrettyFormatStrategy.newBuilder()
        .showThreadInfo(false).methodCount(1).tag(this).build()
    return object : AndroidLogAdapter(formatStrategy) {
        override fun isLoggable(priority: Int, tag: String?): Boolean {
            return debug
        }
    }
}

/**
 * 转换String
 */
fun Any?.toJsonString(): String {
    return Gson().toJson(this)
}

class ParameterizedTypeImpl(private val clazz: Class<*>) : ParameterizedType {
    override fun getRawType(): Type = List::class.java
    override fun getOwnerType(): Type? = null
    override fun getActualTypeArguments(): Array<Type> = arrayOf(clazz)
}

/**
 * String转换List
 */
inline fun <reified T> String?.toJsonArray(): List<T>? {
    return Gson().fromJson<List<T>>(this, ParameterizedTypeImpl(T::class.java))
}

/**
 * 转换成对象
 */
inline fun <reified T> String.toJsonObject(): T {
    return Gson().fromJson(this, T::class.java)
}