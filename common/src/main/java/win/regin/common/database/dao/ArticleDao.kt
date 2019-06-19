package win.regin.common.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import win.regin.common.database.ArticleEntity

/**
 * @author :Reginer in  19-6-19 下午7:11.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
@Dao
abstract class ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(articleEntity: ArticleEntity)


    @Query("DELETE FROM article WHERE curPage = :curPage")
    abstract fun queryByPage(curPage: Int): List<ArticleEntity>

}
