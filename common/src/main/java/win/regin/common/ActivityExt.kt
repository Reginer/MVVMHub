package win.regin.common

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * @author :Reginer in  2019/11/25 19:38.
 *         联系方式:QQ:282921012
 *         功能描述:Activity跳转扩展
 */

inline fun <reified TARGET : Activity> FragmentActivity.startActivity(vararg params: Pair<String, Any>) {
    ActivityMessenger.startActivity<TARGET>(this, *params)
}

inline fun <reified TARGET : Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    ActivityMessenger.startActivity<TARGET>(this, *params)
}

inline fun <reified TARGET : Activity> FragmentActivity.startActivityForResult(
    vararg params: Pair<String, Any>,
    crossinline callback: ((result: Intent?) -> Unit)
) {
    ActivityMessenger.startActivityForResult<TARGET>(this, *params, callback = callback)
}

inline fun <reified TARGET : Activity> Fragment.startActivityForResult(
    vararg params: Pair<String, Any>,
    crossinline callback: ((result: Intent?) -> Unit)
) {
    ActivityMessenger.startActivityForResult<TARGET>(this, *params, callback = callback)
}

