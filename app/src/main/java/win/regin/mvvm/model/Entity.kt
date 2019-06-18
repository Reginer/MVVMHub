package win.regin.mvvm.model

import com.google.gson.Gson

/**
 * @author :Reginer in  2019/6/18 21:06.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
data class BaseEntity<T>(
    var errorCode: Int = 1,
    var errorMsg: String = "",
    var data: T
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

data class UserEntity(val username: String? = "")