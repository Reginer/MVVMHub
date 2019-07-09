package win.regin.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import win.regin.base.ext.getVmClazz
import win.regin.base.state.ViewState

/**
 * @author :Reginer in  19-6-18 下午6:05.
 * 联系方式:QQ:282921012
 * 功能描述:
 */

abstract class BaseVmActivity<VM : BaseViewModel> : BaseActivity() {

    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        createObserver()
        super.onCreate(savedInstanceState)
    }


    /**
     * 创建viewModel
     *
     * @return viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProviders.of(this).get(getVmClazz(this) as Class<VM>)
    }

    /**
     * 创建观察者
     */
    protected abstract fun createObserver()

    /**
     * 显示页面状态
     */
    protected fun parseState(viewState: ViewState<*>) {
        when (viewState) {
            is ViewState.Loading -> {
                showProgress()
            }
            is ViewState.Success -> {
                dismissProgress(null)
            }
            is ViewState.Error -> {
                dismissProgress(viewState.error)
            }
        }
    }

}