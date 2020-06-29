# MVVMHub

[![](https://jitpack.io/v/Reginer/MVVMHub.svg)](https://jitpack.io/#Reginer/MVVMHub)

```
implementation 'com.github.Reginer:MVVMHub:2.0.0'
```

登录：
```
class LoginActivity : BaseVmActivity<LoginViewModel>() {

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
```





```
class LoginViewModel : BaseViewModel() {
    private val loginRepository by lazy { LoginRepository() }
    val loginResult: MutableLiveData<ViewState<UserEntity>> = MutableLiveData()

    fun login(username: String, password: String) {
        launchRequest({ loginRepository.login(username, password) }, loginResult)
    }

    fun saveUser(userEntity: UserEntity) {
        loginRepository.insertUser(userEntity)
    }
}
```



## License
```text
MIT License

Copyright (c) 2019 鼎鼎鼎

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
