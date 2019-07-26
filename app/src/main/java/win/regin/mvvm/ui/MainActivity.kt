package win.regin.mvvm.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import win.regin.base.BaseVmActivity
import win.regin.base.ext.parseState
import win.regin.mvvm.R
import win.regin.mvvm.viewmodel.MainViewModel

class MainActivity : BaseVmActivity<MainViewModel>() {


    override val layoutId: Int
        get() = R.layout.activity_main

    override
    fun initView(savedInstanceState: Bundle?) {
        //启动加载第一页，有网没网的，这一会儿0一会儿1的接口实在是秀
        mViewModel.pageLiveData.postValue(1)
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolBar.navigationIcon = null
    }

    override fun createObserver() {
        mViewModel.userLiveData.observe(this, Observer {
            it?.apply { mViewModel.getArticle(0) }
        })
        mViewModel.articleResult.observe(this, Observer { viewState ->
            parseState(viewState, { mViewModel.parseArticleData(it) })
        })
        mViewModel.articleLiveData.observe(this, Observer {
            content.text = Gson().toJson(it)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        startActivity<LoginActivity>()
        return super.onOptionsItemSelected(item)
    }
}
