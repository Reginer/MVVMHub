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
 * 功能描述:Fragment基类，普通Fragment继承
 */
abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    protected abstract val layoutId: Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }

    protected open fun initView(view: View, savedInstanceState: Bundle?) {

    }

}