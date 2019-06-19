package win.regin.common.convert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import win.regin.common.entity.ArticleDataEntity

/**
 * @author :Reginer in  19-6-19 下午6:56.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class ArticleListConvert {
    @TypeConverter
    fun toJson(value: String?): List<ArticleDataEntity>? {
        val type = object : TypeToken<List<ArticleDataEntity>>() {
        }.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toString(value: List<ArticleDataEntity>?): String? {
        return Gson().toJson(value)
    }


}
