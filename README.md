# MVVMHub
登录：
```
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
要抄随意

Free copy at will.
```