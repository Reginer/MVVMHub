package win.regin.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_base_layout.*

/**
 * @author :Reginer in  19-6-18 下午6:02.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var mToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_layout)
        LayoutInflater.from(this).inflate(layoutId, viewContent)
        initView(savedInstanceState)
        initHeaderView()

    }

    override fun onStart() {
        super.onStart()
        initToolBar()
    }

    /**
     * 获取ViewId.
     *
     * @return LayoutId
     */
    @get:LayoutRes
    protected abstract val layoutId: Int

    /**
     * 初始化控件.
     *
     * @param savedInstanceState [onCreate]
     */
    protected abstract fun initView(savedInstanceState: Bundle?)

    private fun initHeaderView() {
        mToolBar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolBar)
        mToolBar.setNavigationOnClickListener { finish() }
    }

    /**
     * 设置ToolBar.
     */
    protected open fun initToolBar() {

    }
}

