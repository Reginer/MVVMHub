package win.regin.mvvm.ui

import android.os.Bundle
import win.regin.base.BaseVmActivity
import win.regin.mvvm.R
import win.regin.mvvm.viewmodel.LoginViewModel

/**
 * @author :Reginer in  2019/6/18 21:23.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginActivity : BaseVmActivity<LoginViewModel>() {
    override val layoutId: Int get() = R.layout.activity_login

    override
    fun initView(savedInstanceState: Bundle?) {
        mViewModel.login("R", "123456789")
    }

}
