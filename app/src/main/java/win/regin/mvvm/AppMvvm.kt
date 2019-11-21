package win.regin.mvvm

import com.orhanobut.logger.Logger
import win.regin.base.constant.HubConstant
import win.regin.common.AppCommon
import win.regin.mvvm.data.BoxManager
import win.regin.common.logTagDebug

/**
 * @author :Reginer in  19-6-19 上午9:35.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class AppMvvm : AppCommon() {
    override fun onCreate() {
        super.onCreate()
        BoxManager.instance.init(this)
        Logger.addLogAdapter(HubConstant.HUB_LOG_TAG.logTagDebug(BuildConfig.DEBUG))
    }
}