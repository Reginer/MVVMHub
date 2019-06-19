package win.regin.mvvm.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import org.jetbrains.anko.startActivity
import win.regin.base.BaseActivity
import win.regin.base.BaseVmActivity
import win.regin.common.utils.Logcat
import win.regin.mvvm.R
import win.regin.mvvm.viewmodel.MainViewModel

class MainActivity : BaseVmActivity<MainViewModel>() {


    override val layoutId: Int
        get() = R.layout.activity_main

    override
    fun initView(savedInstanceState: Bundle?) {
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolBar.navigationIcon = null
    }

    override fun createObserver() {
        mViewModel.userLiveData.observe(this, Observer {
            Logcat.d(it.toString())
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
