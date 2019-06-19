package win.regin.common.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import win.regin.common.database.UserEntity

/**
 * @author :Reginer in  19-6-19 下午4:49.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Dao
abstract class UserDao {

    @Query("SELECT * FROM user")
    abstract fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user")
    abstract fun getAllUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(repositoryEntity: UserEntity)

    @Query("DELETE FROM user")
    abstract fun deleteAll()
}