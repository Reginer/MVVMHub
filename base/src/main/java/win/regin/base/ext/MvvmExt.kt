package win.regin.base.ext

import java.lang.reflect.ParameterizedType

/**
 * @author :Reginer in  19-6-18 下午6:04.
 * 联系方式:QQ:282921012
 * 功能描述:
 */


/**
 * 获取vm clazz
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}