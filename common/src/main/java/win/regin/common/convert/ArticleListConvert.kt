package win.regin.common.convert

import io.objectbox.converter.PropertyConverter
import win.regin.common.entity.ArticleDataEntity
import win.regin.common.toJsonArray
import win.regin.common.toJsonString

/**
 * @author :Reginer in  19-6-19 下午6:56.
 * 联系方式:QQ:282921012
 * 功能描述:List <==> String
 */
class ArticleListConvert : PropertyConverter<List<ArticleDataEntity>, String> {
    override fun convertToDatabaseValue(entityProperty: List<ArticleDataEntity>?): String {
        return entityProperty.toJsonString()
    }


    override fun convertToEntityProperty(databaseValue: String?): List<ArticleDataEntity>? {
        return databaseValue.toJsonArray()
    }

}
