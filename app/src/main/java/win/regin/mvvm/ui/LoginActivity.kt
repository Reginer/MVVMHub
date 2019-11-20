package win.regin.mvvm.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_login.*
import win.regin.base.BaseVmActivity
import win.regin.base.ext.parseState
import win.regin.common.text
import win.regin.mvvm.R
import win.regin.mvvm.viewmodel.LoginViewModel

/**
 * @author :Reginer in  2019/6/18 21:23.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginActivity : BaseVmActivity<LoginViewModel>() {


    override val layoutId: Int get() = R.layout.activity_login


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnLogin.setOnClickListener { mViewModel.login(etUsername.text(), etPwd.text()) }
    }

    override fun createObserver() {
        mViewModel.loginResult.observe(this, Observer { viewState ->
            parseState(viewState, { mViewModel.saveUser(it);finish() }, { Logger.e(it.errorMsg) })
        })
    }
}
