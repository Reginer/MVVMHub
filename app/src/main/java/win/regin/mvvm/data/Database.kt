package win.regin.mvvm.data


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import kotlinx.parcelize.Parcelize
import win.regin.common.toJsonString

/**
 * @author :Reginer in  19-6-19 下午4:42.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Keep
@Entity
@Parcelize
data class UserEntity(
    @Id
    var dbId: Long = 0,
    val username: String? = ""
) : Parcelable {
    override fun toString(): String {
        return this.toJsonString()
    }
}

@Keep
@Entity
@Parcelize
data class ArticleEntity(
    @Id
    var dbId: Long = 0,
    @Unique
    var curPage: Long = 0,
    var offset: Int = 0,
    var isOver: Boolean = false,
    var pageCount: Int = 0,
    var size: Int = 0,
    var total: Int = 0,
    @SerializedName("datas")
    @Convert(converter = ArticleListConvert::class, dbType = String::class)
    var articleList: List<ArticleDataEntity>? = null

) : Parcelable