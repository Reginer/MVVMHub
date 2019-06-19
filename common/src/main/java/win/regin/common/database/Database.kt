package win.regin.common.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import win.regin.common.convert.ArticleListConvert
import win.regin.common.entity.ArticleDataEntity

/**
 * @author :Reginer in  19-6-19 下午4:42.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    var id: Int = 0,
    val username: String? = ""
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

@Entity(tableName = "article")
@TypeConverters(ArticleListConvert::class)
data class ArticleEntity(
    @PrimaryKey
    var curPage: Int = 0,
    var offset: Int = 0,
    var isOver: Boolean = false,
    var pageCount: Int = 0,
    var size: Int = 0,
    var total: Int = 0,
    @SerializedName("datas")
    var articleList: List<ArticleDataEntity>? = null

)