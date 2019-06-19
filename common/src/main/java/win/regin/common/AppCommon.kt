package win.regin.common

import android.app.Application
import kotlin.properties.Delegates

/**
 * @author :Reginer in  19-6-19 上午9:32.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
open class AppCommon : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: AppCommon   by Delegates.notNull()
    }
}
