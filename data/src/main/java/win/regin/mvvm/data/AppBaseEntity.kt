package win.regin.mvvm.data

import win.regin.common.BaseEntity

/**
 * @author :Reginer in  2019/11/21 20:57.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
const val REQUEST_RESULT_SUCCESS = 0

class AppBaseEntity<T>(private var errorCode: Int, private var errorMsg: String, data: T) :
    BaseEntity<T>(errorCode, errorMsg, data) {


    override fun dataRight(): Boolean {
        return errorCode == REQUEST_RESULT_SUCCESS
    }

    override fun getMsg(): String {
        return errorMsg
    }

}