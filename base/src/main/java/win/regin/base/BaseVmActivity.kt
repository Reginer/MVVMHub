package win.regin.base

import android.os.Bundle

/**
 * @author :Reginer in  19-6-18 下午6:05.
 * 联系方式:QQ:282921012
 * 功能描述:ViewModelActivity基类，ViewModelActivity继承
 */

abstract class BaseVmActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createObserver()
    }


    /**
     * 创建观察者
     */
    abstract fun createObserver()


}