package win.regin.common.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import win.regin.common.toJsonString

/**
 * @author :Reginer in  19-6-19 下午6:49.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Keep
data class BaseEntity<T>(
    var errorCode: Int = 1,
    var errorMsg: String = "",
    var data: T
) {
    override fun toString(): String {
        return this.toJsonString()
    }
}

@Keep
@Parcelize
data class ArticleTagEntity(
    val name: String? = null,
    val url: String? = null
) : Parcelable {
    override fun toString(): String {
        return this.toJsonString()
    }
}

@Keep
@Parcelize
data class ArticleDataEntity(
    var apkLink: String? = null,
    var author: String? = null,
    var chapterId: Int = 0,
    var chapterName: String? = null,
    var isCollect: Boolean = false,
    var courseId: Int = 0,
    var desc: String? = null,
    var envelopePic: String? = null,
    var isFresh: Boolean = false,
    var id: Int = 0,
    var link: String? = null,
    var niceDate: String? = null,
    var origin: String? = null,
    var prefix: String? = null,
    var projectLink: String? = null,
    var publishTime: Long = 0,
    var superChapterId: Int = 0,
    var superChapterName: String? = null,
    var title: String? = null,
    var type: Int = 0,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0,
    var tags: List<ArticleTagEntity>? = null
) : Parcelable {
    override fun toString(): String {
        return this.toJsonString()
    }
}