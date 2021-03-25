package win.regin.mvvm.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_login.*
import win.regin.base.BaseVmActivity
import win.regin.base.ext.vmObserver
import win.regin.common.text
import win.regin.mvvm.R
import win.regin.mvvm.viewmodel.LoginViewModel

/**
 * @author :Reginer in  2019/6/18 21:23.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
class LoginActivity : BaseVmActivity() {

    private val mViewModel by viewModels<LoginViewModel>()

    override val layoutId: Int get() = R.layout.activity_login


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnLogin.setOnClickListener { mViewModel.login(etUsername.text(), etPwd.text()) }
    }

    override fun createObserver() {

        mViewModel.loginResult.vmObserver(this) {
            onAppLoading = { showProgress() }
            onAppSuccess = { mViewModel.saveUser(it);finish() }
            onAppError = { Logger.e(it.errorMsg) }
            onAppComplete = { dismissProgress() }
        }
        //不管那一套，直接取成功就完事了
//        mViewModel.loginResult.vmObserver(this) {
//            onAppSuccess = { mViewModel.saveUser(it);finish() }
//        }
    }
}
