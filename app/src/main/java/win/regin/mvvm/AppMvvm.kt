package win.regin.mvvm

import win.regin.common.AppCommon
import win.regin.common.database.BoxManager

/**
 * @author :Reginer in  19-6-19 上午9:35.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class AppMvvm : AppCommon() {
    override fun onCreate() {
        super.onCreate()
        BoxManager.init(this)
    }
}