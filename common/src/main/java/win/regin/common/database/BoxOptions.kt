package win.regin.common.database

import io.objectbox.query.Query

/**
 * @author :Reginer in  19-6-20 下午1:41.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
object BoxOptions {


    fun getAllUserLiveData(): Query<UserEntity> {
        return BoxManager.instance.boxStore.boxFor(UserEntity::class.java).query().build()

    }

    fun insertUser(userEntity: UserEntity) {
        BoxManager.instance.boxStore.boxFor(UserEntity::class.java).put(userEntity)
    }

    fun deleteAllUser() {
        BoxManager.instance.boxStore.boxFor(UserEntity::class.java).removeAll()
    }

    fun insertArticle(articleEntity: ArticleEntity) {
        val box = BoxManager.instance.boxStore.boxFor(ArticleEntity::class.java)
        val ifIndex = box.all.find { it.curPage == articleEntity.curPage }
        ifIndex?.let { articleEntity.dbId = it.dbId }
        box.put(articleEntity)

    }

    fun queryArticle(): Query<ArticleEntity> {
        return BoxManager.instance.boxStore.boxFor(ArticleEntity::class.java).query().build()
    }
}