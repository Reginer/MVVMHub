package win.regin.common.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson

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