package win.regin.common.convert

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.converter.PropertyConverter
import win.regin.common.entity.ArticleDataEntity

/**
 * @author :Reginer in  19-6-19 下午6:56.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class ArticleListConvert :  PropertyConverter<List<ArticleDataEntity>,String> {
    override fun convertToDatabaseValue(entityProperty: List<ArticleDataEntity>?): String {
        return Gson().toJson(entityProperty)
    }


    override fun convertToEntityProperty(databaseValue: String?): List<ArticleDataEntity>? {
        val type = object : TypeToken<List<ArticleDataEntity>>() {
        }.type
        return Gson().fromJson(databaseValue, type)
    }

}
