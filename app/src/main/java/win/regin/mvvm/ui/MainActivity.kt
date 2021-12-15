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
package win.regin.mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import win.regin.base.BaseVmActivity
import win.regin.base.ext.vmObserver
import win.regin.common.toJsonString
import win.regin.mvvm.R
import win.regin.mvvm.databinding.ActivityMainBinding
import win.regin.mvvm.viewmodel.MainViewModel

/**
 * @author :Reginer  2019/6/16 14:37.
 *         联系方式:QQ:282921012
 *         功能描述:主页面
 */
class MainActivity : BaseVmActivity() {

    private val mViewModel by viewModels<MainViewModel>()

    /**
     * private val mViewBinding by viewBinding<ActivityMainBinding>()
     */
    private val mViewBinding by viewBinding(ActivityMainBinding::bind, R.id.root)

    override val layoutId: Int get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.pageLiveData.postValue(1)
    }

    override fun initToolBar() {
        super.initToolBar()
        mToolBar.navigationIcon = null
    }

    override fun createObserver() {
        mViewModel.userLiveData.observe(this) {
            it?.let { mViewModel.getArticle(0) }
        }
        mViewModel.articleResult.vmObserver(this) {
            onAppSuccess { mViewModel.parseArticleData(it) }
        }
        mViewModel.articleLiveData.observe(this) {
            mViewBinding.content.text = it.toJsonString()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, LoginActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}
