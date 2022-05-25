package win.regin.mvvm

import android.widget.EditText
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * @author :Reginer  2021/12/1 15:16.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
fun EditText.text():String{
    return this.text.toString()
}


/**
 * 设置是否打印和打印tag
 */
fun String.logTagDebug(debug: Boolean): AndroidLogAdapter {
    val formatStrategy = PrettyFormatStrategy.newBuilder()
        .showThreadInfo(false).methodCount(1).tag(this).build()
    return object : AndroidLogAdapter(formatStrategy) {
        override fun isLoggable(priority: Int, tag: String?): Boolean {
            return debug
        }
    }
}