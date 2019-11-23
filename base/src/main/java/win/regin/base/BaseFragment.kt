package win.regin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author :Reginer in  2019/11/23 10:00.
 * 联系方式:QQ:282921012
 * 功能描述:Fragment基类，普通Activity继承
 */
abstract class BaseFragment : Fragment() {
    /**
     * 获取布局id
     *
     * @return layoutId
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false);
    }
}