package win.regin.mvvm.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_login.*
import win.regin.base.BaseVmActivity
import win.regin.base.state.ViewState
import win.regin.common.text
import win.regin.common.utils.Logcat
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

        btnLogin.setOnClickListener {
            mViewModel.login(etUsername.text(), etPwd.text())
        }

    }

    override fun createObserver() {
        mViewModel.loginResult.observe(this, Observer {
            when (it) {
                is ViewState.Success -> {
                    mViewModel.saveUser(it.data)
                    finish()
                }
                is ViewState.Error -> {
                    Logcat.e(it.error.errorMsg)
                }
            }
        })
    }

}
