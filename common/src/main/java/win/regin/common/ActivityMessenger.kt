@file:Suppress("UNCHECKED_CAST", "unused", "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE", "SpellCheckingInspection")

package win.regin.common

import android.content.Context
import android.content.Intent
import android.os.BaseBundle
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import win.regin.common.IntentFieldMethod.internalMap
import java.io.Serializable
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * @author wuyr
 * @github https://github.com/wuyr/ActivityMessenger
 * @since 2019-08-05 上午11:56
 */
/**
 * 获取Intent参数，Activity
 * 示例：
 *  <p>
 *
 *      private var str: String? by extraAct("String")
 *      private var str1 by extraAct("String1", "123")
 *      private var int1 by extraAct("Int1", 123)
 *
 *      Log.e("TestActivity", "str---------$str") // get
 *      str = "str" // set
 *      Log.e("TestActivity", "str1---------$str1") // get
 *      str1 = "str1" // set
 *      Log.e("TestActivity", "int1---------$int1") // get
 *      int1 = 1000 // set
 * </p>
 *
 * @author Jowan
 * Created on 2019/8/15.
 */
class ActivityExtras<T>(private val extraName: String, private val defaultValue: T) :
    ReadWriteProperty<FragmentActivity, T> {

    /**
     * getExtras字段对应的值
     */
    private var extra: T? = null

    override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
        // 如果extra不为空则返回extra
        // 如果extra是空的，则判断intent的参数的值，如果值不为空，则将值赋予extra，并且返回
        // 如果intent参数的值也为空，则返回defaultValue，并且将值赋予extra
        return extra ?: thisRef.intent?.get<T>(extraName)?.also { extra = it }
        ?: defaultValue.also { extra = it }
    }

    override fun setValue(thisRef: FragmentActivity, property: KProperty<*>, value: T) {
        extra = value
    }
}

/**
 * 获取Intent参数，Fragment
 * 示例同[ActivityExtras]
 */
class FragmentExtras<T>(private val extraName: String, private val defaultValue: T) :
    ReadWriteProperty<Fragment, T> {

    /**
     * getExtras字段对应的值
     */
    private var extra: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        // 如果extra不为空则返回extra
        // 如果extra是空的，则判断intent的参数的值，如果值不为空，则将值赋予extra，并且返回
        // 如果intent参数的值也为空，则返回defaultValue，并且将值赋予extra
        return extra ?: thisRef.arguments?.get<T>(extraName)?.also { extra = it }
        ?: defaultValue.also { extra = it }
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        extra = value
    }
}

fun <T> extraFrag(extraName: String): FragmentExtras<T?> = FragmentExtras(extraName, null)

fun <T> extraFrag(extraName: String, defaultValue: T): FragmentExtras<T> =
    FragmentExtras(extraName, defaultValue)


fun <T> extraAct(extraName: String): ActivityExtras<T?> = ActivityExtras(extraName, null)

fun <T> extraAct(extraName: String, defaultValue: T): ActivityExtras<T> =
    ActivityExtras(extraName, defaultValue)

/**
 * [Intent]的扩展方法，此方法可无视类型直接获取到对应值
 * 如getStringExtra()、getIntExtra()、getSerializableExtra()等方法通通不用
 * 可以直接通过此方法来获取到对应的值，例如：
 * <pre>
 *     var mData: List<String>? = null
 *     mData = intent.get("Data")
 * </pre>
 * 而不用显式强制转型
 *
 * @param key 对应的Key
 * @return 对应的Value
 */
fun <O> Intent?.get(key: String, defaultValue: O? = null) =
    this?.internalMap()?.get(key) as? O ?: defaultValue

/**
 * 作用同Intent.[get]
 */
fun <O> Bundle?.get(key: String, defaultValue: O? = null) =
    this?.internalMap()?.get(key) as? O ?: defaultValue

/**
 *  [Intent]的扩展方法，用来批量put键值对
 *  示例：
 *  <pre>
 *      intent.putExtras(
 *          "Key1" to "Value",
 *          "Key2" to 123,
 *          "Key3" to false,
 *          "Key4" to arrayOf("4", "5", "6")
 *      )
 * </pre>
 *
 * @param params 键值对
 */
fun <T> Intent.putExtras(vararg params: Pair<String, T>): Intent {
    if (params.isEmpty()) return this
    params.forEach { (key, value) ->
        when (value) {
            is Int -> putExtra(key, value)
            is Byte -> putExtra(key, value)
            is Char -> putExtra(key, value)
            is Long -> putExtra(key, value)
            is Float -> putExtra(key, value)
            is Short -> putExtra(key, value)
            is Double -> putExtra(key, value)
            is Boolean -> putExtra(key, value)
            is Bundle -> putExtra(key, value)
            is String -> putExtra(key, value)
            is IntArray -> putExtra(key, value)
            is ByteArray -> putExtra(key, value)
            is CharArray -> putExtra(key, value)
            is LongArray -> putExtra(key, value)
            is FloatArray -> putExtra(key, value)
            is Parcelable -> putExtra(key, value)
            is ShortArray -> putExtra(key, value)
            is DoubleArray -> putExtra(key, value)
            is BooleanArray -> putExtra(key, value)
            is CharSequence -> putExtra(key, value)
            is Array<*> -> {
                when {
                    value.isArrayOf<String>() ->
                        putExtra(key, value as Array<String?>)
                    value.isArrayOf<Parcelable>() ->
                        putExtra(key, value as Array<Parcelable?>)
                    value.isArrayOf<CharSequence>() ->
                        putExtra(key, value as Array<CharSequence?>)
                    else -> putExtra(key, value)
                }
            }
            is Serializable -> putExtra(key, value)
        }
    }
    return this
}

/**
 *  作用同[FragmentActivity.startActivity]
 *  示例：
 *  <pre>
 *      //不携带参数
 *      startActivity<TestActivity>()
 *
 *      //携带参数（可连续多个键值对）
 *      startActivity<TestActivity>("Key" to "Value")
 *  </pre>
 *
 * @param TARGET 要启动的Activity
 * @param params extras键值对
 */
inline fun <reified TARGET : FragmentActivity> FragmentActivity.startActivity(
    vararg params: Pair<String, Any?>
) = startActivity(Intent(this, TARGET::class.java).putExtras(*params))

inline fun <reified TARGET : FragmentActivity> Fragment.startActivity(
    vararg params: Pair<String, Any?>
) = activity?.run {
    startActivity(Intent(this, TARGET::class.java).putExtras(*params))
}

/**
 *  Fragment跳转，同[FragmentActivity.startActivity]
 *  示例：
 *  <pre>
 *      //不携带参数
 *      startActivity(this, TestActivity::class)
 *
 *      //携带参数（可连续多个键值对）
 *     startActivity(
 *         TestActivity::class,
 *         "Key1" to "Value",
 *         "Key2" to 123
 *     )
 *  </pre>
 *
 * @param target 要启动的Activity
 * @param params extras键值对
 */
fun FragmentActivity.startActivity(
    target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>
) = startActivity(Intent(this, target.java).putExtras(*params))

fun Fragment.startActivity(
    target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>
) = activity?.run {
    startActivity(Intent(this, target.java).putExtras(*params))
}


/**
 * 作用同上，以下三个方法为了兼容Java Class
 */
fun FragmentActivity.startActivity(
    target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>
) = startActivity(Intent(this, target).putExtras(*params))

fun Fragment.startActivity(
    target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>
) = activity?.run {
    startActivity(Intent(this, target).putExtras(*params))
}
/**
 *  作用同[FragmentActivity.startActivityForResult]
 *  示例：
 *  <pre>
 *      //不携带参数
 *      startActivityForResult<TestActivity> {
 *          if (it == null) {
 *              //未成功处理，即（ResultCode != RESULT_OK）
 *          } else {
 *              //处理成功，这里可以操作返回的intent
 *          }
 *      }
 *  </pre>
 *  携带参数同[startActivity]
 *
 * @param TARGET 要启动的Activity
 * @param params extras键值对
 * @param callback onActivityResult的回调
 */
inline fun <reified TARGET : FragmentActivity> FragmentActivity.startActivityForResult(
    vararg params: Pair<String, Any?>, crossinline callback: ((result: Intent?) -> Unit)
) = startActivityForResult(TARGET::class, *params, callback = callback)

inline fun <reified TARGET : FragmentActivity> Fragment.startActivityForResult(
    vararg params: Pair<String, Any?>, crossinline callback: ((result: Intent?) -> Unit)
) = activity?.startActivityForResult(TARGET::class, *params, callback = callback)


/**
 *  作用同[FragmentActivity.startActivityForResult]
 *  示例：
 *  <pre>
 *      //不携带参数
 *      startActivityForResult(this, TestActivity::class) {
 *          if (it == null) {
 *              //未成功处理，即（ResultCode != RESULT_OK）
 *          } else {
 *              //处理成功，这里可以操作返回的intent
 *          }
 *      }
 *  </pre>
 *  携带参数同[startActivity]
 *
 * @param target 要启动的Activity
 * @param params extras键值对
 * @param callback onActivityResult的回调
 */
inline fun FragmentActivity.startActivityForResult(
    target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>,
    crossinline callback: ((result: Intent?) -> Unit)
) = ActivityMessenger.startActivityForResult(this, target, *params, callback = callback)

inline fun Fragment.startActivityForResult(
    target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>,
    crossinline callback: ((result: Intent?) -> Unit)
) = activity?.run {
    ActivityMessenger.startActivityForResult(this, target, *params, callback = callback)
}


/**
 * 作用同上，以下三个方法为了兼容Java Class
 */
inline fun FragmentActivity.startActivityForResult(
    target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>,
    crossinline callback: ((result: Intent?) -> Unit)
) = ActivityMessenger.startActivityForResult(this, target, *params, callback = callback)

inline fun Fragment.startActivityForResult(
    target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>,
    crossinline callback: ((result: Intent?) -> Unit)
) = activity?.run {
    ActivityMessenger.startActivityForResult(this, target, *params, callback = callback)
}


/**
 *  作用同[FragmentActivity.startActivityForResult]
 *
 * @param intent intent
 * @param callback onActivityResult的回调
 */
inline fun FragmentActivity?.startActivityForResult(
    intent: Intent, crossinline callback: ((result: Intent?) -> Unit)
) = this?.run {
    ActivityMessenger.startActivityForResult(this, intent, callback)
}

inline fun Fragment.startActivityForResult(
    intent: Intent, crossinline callback: ((result: Intent?) -> Unit)
) = activity?.run {
    ActivityMessenger.startActivityForResult(this, intent, callback)
}

/**
 *  作用同[FragmentActivity.finish]
 *  示例：
 *  <pre>
 *      finish(this, "Key" to "Value")
 *  </pre>
 *
 * @param params extras键值对
 */
fun FragmentActivity.finish(vararg params: Pair<String, Any?>) = run {
    setResult(FragmentActivity.RESULT_OK, Intent().putExtras(*params))
    finish()
}

fun FragmentActivity.finish(intent: Intent) = run {
    setResult(FragmentActivity.RESULT_OK, intent)
    finish()
}

/**
 * String转Intent对象
 *
 *  示例：
 *  <pre>
 *      val action = "android.media.action.IMAGE_CAPTURE"
 *      val intent = action.toIntent()
 *  </pre>
 *
 * @param flags [Intent.setFlags]
 */
fun String.toIntent(flags: Int = 0): Intent = Intent(this).setFlags(flags)

/**
 * 可空对象转非空对象
 */
inline fun <O> O?.runIfNonNull(block: (O) -> Unit) {
    this?.let { block(it) }
}

/**
 * 不报错执行
 */
inline fun <T, R> T.runSafely(block: (T) -> R) = try {
    block(this)
} catch (e: Exception) {
    e.printStackTrace()
    null
}

internal object IntentFieldMethod {
    private val bundleClass =
        (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) BaseBundle::class else Bundle::class).java

    private val mExtras: Field? by lazy {
        Intent::class.java.getDeclaredField("mExtras").also { it.isAccessible = true }
    }

    private val mMap: Field? by lazy {
        runSafely {
            bundleClass.getDeclaredField("mMap").also {
                it.isAccessible = true
            }
        }
    }

    private val unparcel: Method? by lazy {
        runSafely {
            bundleClass.getDeclaredMethod("unparcel").also {
                it.isAccessible = true
            }
        }
    }

    internal fun Intent.internalMap() = runSafely {
        mMap?.get((mExtras?.get(this) as? Bundle).also {
            it?.run { unparcel?.invoke(this) }
        }) as? Map<String, Any?>
    }

    internal fun Bundle.internalMap() = runSafely {
        unparcel?.invoke(it)
        mMap?.get(it) as? Map<String, Any?>
    }
}

object ActivityMessenger {
    private var sRequestCode = 0
        set(value) {
            field = if (value >= Integer.MAX_VALUE) 1 else value
        }

    /**
     *  作用同[FragmentActivity.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity<TestActivity>(this)
     *
     *      //携带参数（可连续多个键值对）
     *      ActivityMessenger.startActivity<TestActivity>(this, "Key" to "Value")
     *  </pre>
     *
     * @param TARGET 要启动的Activity
     * @param starter 发起的Activity
     * @param params extras键值对
     */
    inline fun <reified TARGET : FragmentActivity> startActivity(
        starter: FragmentActivity, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, TARGET::class.java).putExtras(*params))

    /**
     *  Fragment跳转，同[FragmentActivity.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity<TestActivity>(this)
     *
     *      //携带参数（可连续多个键值对）
     *      ActivityMessenger.startActivity<TestActivity>(this, "Key" to "Value")
     *  </pre>
     *
     * @param TARGET 要启动的Activity
     * @param starter 发起的Fragment
     * @param params extras键值对
     */
    inline fun <reified TARGET : FragmentActivity> startActivity(
        starter: Fragment, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter.activity, TARGET::class.java).putExtras(*params))

    /**
     * Adapter跳转，同[Context.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity<TestActivity>(context)
     *
     *      //携带参数（可连续多个键值对）
     *      ActivityMessenger.startActivity<TestActivity>(context, "Key" to "Value")
     *  </pre>
     *
     * @param TARGET 要启动的Context
     * @param starter 发起的Fragment
     * @param params extras键值对
     */
    inline fun <reified TARGET : FragmentActivity> startActivity(
        starter: Context, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, TARGET::class.java).putExtras(*params))

    /**
     *  作用同[FragmentActivity.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity(this, TestActivity::class)
     *
     *      //携带参数（可连续多个键值对）
     *     ActivityMessenger.startActivity(
     *         this, TestActivity::class,
     *         "Key1" to "Value",
     *         "Key2" to 123
     *     )
     *  </pre>
     *
     * @param starter 发起的Activity
     * @param target 要启动的Activity
     * @param params extras键值对
     */
    fun startActivity(
        starter: FragmentActivity, target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, target.java).putExtras(*params))

    /**
     * 作用同上，此方法为了兼容Java Class
     */
    fun startActivity(
        starter: FragmentActivity, target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, target).putExtras(*params))

    /**
     *  Fragment跳转，同[FragmentActivity.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity(this, TestActivity::class)
     *
     *      //携带参数（可连续多个键值对）
     *     ActivityMessenger.startActivity(
     *         this, TestActivity::class,
     *         "Key1" to "Value",
     *         "Key2" to 123
     *     )
     *  </pre>
     *
     * @param starter 发起的Fragment
     * @param target 要启动的Activity
     * @param params extras键值对
     */
    fun startActivity(
        starter: Fragment, target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter.activity, target.java).putExtras(*params))

    /**
     * 作用同上，此方法为了兼容Java Class
     */
    fun startActivity(
        starter: Fragment, target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter.activity, target).putExtras(*params))

    /**
     *  Adapter里面跳转，同[Context.startActivity]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivity(context, TestActivity::class)
     *
     *      //携带参数（可连续多个键值对）
     *     ActivityMessenger.startActivity(
     *         context, TestActivity::class,
     *         "Key1" to "Value",
     *         "Key2" to 123
     *     )
     *  </pre>
     *
     * @param starter 发起的Context
     * @param target 要启动的Activity
     * @param params extras键值对
     */
    fun startActivity(
        starter: Context, target: KClass<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, target.java).putExtras(*params))

    /**
     * 作用同上，此方法为了兼容Java Class
     */
    fun startActivity(
        starter: Context, target: Class<out FragmentActivity>, vararg params: Pair<String, Any?>
    ) = starter.startActivity(Intent(starter, target).putExtras(*params))

    /**
     *  作用同[FragmentActivity.startActivityForResult]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivityForResult<TestActivity> {
     *          if (it == null) {
     *              //未成功处理，即（ResultCode != RESULT_OK）
     *          } else {
     *              //处理成功，这里可以操作返回的intent
     *          }
     *      }
     *  </pre>
     *  携带参数同[startActivity]
     *
     * @param TARGET 要启动的Activity
     * @param starter 发起的Activity
     * @param params extras键值对
     * @param callback onActivityResult的回调
     */
    inline fun <reified TARGET : FragmentActivity> startActivityForResult(
        starter: FragmentActivity, vararg params: Pair<String, Any?>,
        crossinline callback: ((result: Intent?) -> Unit)
    ) = startActivityForResult(starter, TARGET::class, *params, callback = callback)

    /**
     *  Fragment跳转，同[FragmentActivity.startActivityForResult]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivityForResult<TestActivity> {
     *          if (it == null) {
     *              //未成功处理，即（ResultCode != RESULT_OK）
     *          } else {
     *              //处理成功，这里可以操作返回的intent
     *          }
     *      }
     *  </pre>
     *  携带参数同[startActivity]
     *
     * @param TARGET 要启动的Activity
     * @param starter 发起的Activity
     * @param params extras键值对
     * @param callback onActivityResult的回调
     */
    inline fun <reified TARGET : FragmentActivity> startActivityForResult(
        starter: Fragment, vararg params: Pair<String, Any?>,
        crossinline callback: ((result: Intent?) -> Unit)
    ) = startActivityForResult(starter.activity, TARGET::class, *params, callback = callback)

    /**
     *  作用同[FragmentActivity.startActivityForResult]
     *  示例：
     *  <pre>
     *      //不携带参数
     *      ActivityMessenger.startActivityForResult(this, TestActivity::class) {
     *          if (it == null) {
     *              //未成功处理，即（ResultCode != RESULT_OK）
     *          } else {
     *              //处理成功，这里可以操作返回的intent
     *          }
     *      }
     *  </pre>
     *  携带参数同[startActivity]
     *
     * @param starter 发起的Activity
     * @param target 要启动的Activity
     * @param params extras键值对
     * @param callback onActivityResult的回调
     */
    inline fun startActivityForResult(
        starter: FragmentActivity?, target: KClass<out FragmentActivity>,
        vararg params: Pair<String, Any?>, crossinline callback: ((result: Intent?) -> Unit)
    ) = starter.runIfNonNull {
        startActivityForResult(it, Intent(it, target.java).putExtras(*params), callback)
    }

    /**
     * 作用同上，此方法为了兼容Java Class
     */
    inline fun startActivityForResult(
        starter: FragmentActivity?, target: Class<out FragmentActivity>,
        vararg params: Pair<String, Any?>, crossinline callback: ((result: Intent?) -> Unit)
    ) = starter.runIfNonNull {
        startActivityForResult(it, Intent(it, target).putExtras(*params), callback)
    }

    inline fun startActivityForResult(
        starter: FragmentActivity?, intent: Intent, crossinline callback: ((result: Intent?) -> Unit)
    ) = starter.runIfNonNull {
        val fragment = GhostFragment()
        fragment.init(++sRequestCode, intent) { result ->
            callback(result)
            it.supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
        }
        it.supportFragmentManager.beginTransaction().add(fragment, GhostFragment::class.java.simpleName)
            .commitAllowingStateLoss()
    }

    /**
     *  作用同[FragmentActivity.finish]
     *  示例：
     *  <pre>
     *      ActivityMessenger.finish(this, "Key" to "Value")
     *  </pre>
     *
     * @param src 发起的Activity
     * @param params extras键值对
     */
    fun finish(src: FragmentActivity, vararg params: Pair<String, Any?>) = src.run {
        setResult(FragmentActivity.RESULT_OK, Intent().putExtras(*params))
        finish()
    }

    /**
     *  Fragment调用，作用同[FragmentActivity.finish]
     *  示例：
     *  <pre>
     *      ActivityMessenger.finish(this, "Key" to "Value")
     *  </pre>
     *
     * @param src 发起的Fragment
     * @param params extras键值对
     */
    fun finish(src: Fragment, vararg params: Pair<String, Any?>) =
        src.activity?.run { finish(this, *params) }
}

class GhostFragment : Fragment() {

    private var requestCode = -1
    private var intent: Intent? = null
    private var callback: ((result: Intent?) -> Unit)? = null

    fun init(requestCode: Int, intent: Intent, callback: ((result: Intent?) -> Unit)) {
        this.requestCode = requestCode
        this.intent = intent
        this.callback = callback
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        intent?.let { startActivityForResult(it, requestCode) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == this.requestCode) {
            val result = if (resultCode == FragmentActivity.RESULT_OK && data != null) data else null
            callback?.let { it(result) }
        }
    }

    override fun onDetach() {
        super.onDetach()
        intent = null
        callback = null
    }
}