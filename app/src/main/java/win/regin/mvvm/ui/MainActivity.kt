package win.regin.mvvm.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import win.regin.base.BaseVmActivity
import win.regin.base.ext.parseState
import win.regin.common.startActivity
import win.regin.common.toJsonString
import win.regin.mvvm.R
import win.regin.mvvm.databinding.ActivityMainBinding
import win.regin.mvvm.viewmodel.MainViewModel

/**
 * @author :Reginer  2019/6/16 14:37.
 *         联系方式:QQ:282921012
 *         功能描述:主页面
 */
class MainActivity : BaseVmActivity() {

    private val mViewModel by viewModels<MainViewModel>()

    /**
     * private val mViewBinding by viewBinding<ActivityMainBinding>()
     */
    private val mViewBinding by viewBinding(ActivityMainBinding::bind, R.id.root)

    override val layoutId: Int get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.pageLiveData.postValue(1)
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolBar.navigationIcon = null
    }

    override fun createObserver() {
        mViewModel.userLiveData.observe(this, {
            it?.let { mViewModel.getArticle(0) }
        })
        mViewModel.articleResult.observe(this, { viewState ->
            parseState(viewState, { mViewModel.parseArticleData(it) })
        })
        mViewModel.articleLiveData.observe(this, {
            mViewBinding.content.text = it.toJsonString()
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity<LoginActivity>()
        return super.onOptionsItemSelected(item)
    }
}
