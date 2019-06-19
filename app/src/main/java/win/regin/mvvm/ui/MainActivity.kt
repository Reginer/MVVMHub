package win.regin.mvvm.ui

import android.os.Bundle
import win.regin.base.BaseActivity
import win.regin.mvvm.R

class MainActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override
    fun initView(savedInstanceState: Bundle?) {
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolBar.navigationIcon = null
    }

}
