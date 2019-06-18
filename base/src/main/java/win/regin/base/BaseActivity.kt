package win.regin.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @author :Reginer in  19-6-18 下午6:02.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
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
}

