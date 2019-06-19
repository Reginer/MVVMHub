package win.regin.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import win.regin.common.database.dao.UserDao

/**
 * @author :Reginer in  19-6-19 下午4:44.
 * 联系方式:QQ:282921012
 * 功能描述:
 */

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao
}