package win.regin.common

import androidx.annotation.Keep

/**
 * @author :Reginer in  19-6-19 下午6:49.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Keep
data class BaseEntity<T>(
    var errorCode: Int = 1,
    var errorMsg: String = "",
    var data: T
) {
    override fun toString(): String {
        return this.toJsonString()
    }

    /**
     * 数据是否正确，默认实现
     */
    fun dataRight(): Boolean {
        return errorCode == 0
    }
}


