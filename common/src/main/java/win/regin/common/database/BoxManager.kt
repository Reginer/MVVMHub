package win.regin.common.database

import android.app.Application
import io.objectbox.BoxStore

/**
 * @author :Reginer in  19-6-20 下午12:05.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class BoxManager private constructor() {
    private object BoxManagerHolder {
        val INSTANCE = BoxManager()
    }

    companion object {
        val instance: BoxManager by lazy { BoxManagerHolder.INSTANCE }
    }

    lateinit var boxStore: BoxStore
    fun init(application: Application) {
        boxStore = MyObjectBox.builder().androidContext(application).build()
    }


}