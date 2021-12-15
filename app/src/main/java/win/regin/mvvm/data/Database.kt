/*
 * Copyright (c) 2021, Reginer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 */
package win.regin.mvvm.data


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.objectbox.annotation.*
import kotlinx.parcelize.Parcelize
import win.regin.common.toJsonString

/**
 * @author :Reginer  19-6-19 下午4:42.
 * 联系方式:QQ:282921012
 * 功能描述:数据库列表
 */
@Keep
@Entity
@Parcelize
data class UserEntity(
    @Id
    var dbId: Long = 0,
    @Unique(onConflict = ConflictStrategy.REPLACE)
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
    @Unique(onConflict = ConflictStrategy.REPLACE)
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