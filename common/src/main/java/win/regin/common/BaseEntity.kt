package win.regin.common

import androidx.annotation.Keep

/**
 * @author :Reginer in  19-6-19 下午6:49.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Keep
open class BaseEntity<T>(
    private var code: Int = 1,
    private var message: String = "",
    var data: T
) {
    override fun toString(): String {
        return this.toJsonString()
    }

    /**
     * 数据是否正确，默认实现
     */
    open fun dataRight(): Boolean {
        return code == 0
    }

    /**
     * 获取错误信息，默认实现
     */
    open fun getMsg(): String {
        return message
    }
}


