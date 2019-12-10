package win.regin.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import win.regin.base.ext.getVmClazz

/**
 * @author :Reginer in  2019/11/23 10:11.
 * 联系方式:QQ:282921012
 * 功能描述:ViewModelFragment基类，ViewModelFragment继承
 */
abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
        createObserver()
    }

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this) as Class<VM>)
    }

    /**
     * 创建观察者
     */
    protected abstract fun createObserver()
}