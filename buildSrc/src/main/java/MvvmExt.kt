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
/**
 * @author :Reginer  19-6-18 下午3:50.
 * 联系方式:QQ:282921012
 * 功能描述:环境变量
 */
object AppConfig {
    const val versionName = "1.0"
    const val versionCode = 1
    const val applicationId = "win.regin.mvvm"
    const val buildToolsVersion = "33.0.2"
    const val compileSdkVersion = 33
    const val targetSdkVersion = 33
    const val minSdkVersion = 21
    const val storePassword = "ly9999"
    const val keyAlias = "那时年少"
    const val storeFile = "../keystore/Young.jks"
}

object Version {
    const val gradleVersion = "7.4.2"
    const val kotlinVersion = "1.9.20"
    const val retrofitVersion = "2.9.0"


    //http://jcenter.bintray.com/com/squareup/okhttp3/logging-interceptor/
    const val materialVersion = "1.8.0"
    const val loggerVersion = "2.2.0"
    const val libVersionCode = 39
    const val libVersionName = "2.1.11"
}

object MvvmExt {
    const val buildGradle = "com.android.tools.build:gradle:${Version.gradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    const val ktx = "androidx.core:core-ktx:1.10.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val junit = "junit:junit:4.13.2"
    const val extUnit = "androidx.test.ext:junit:1.1.5"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.1"

    //https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"

    //https://github.com/google/gson
    const val gson = "com.google.code.gson:gson:2.10.1"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:4.10.0"

    //https://github.com/Kotlin/kotlinx.coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    const val material = "com.google.android.material:material:${Version.materialVersion}"

    // https://github.com/objectbox/objectbox-java
    const val objectboxGradlePlugin = "io.objectbox:objectbox-gradle-plugin:3.5.1"

    //https://github.com/orhanobut/logger
    const val logger = "com.orhanobut:logger:${Version.loggerVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.6"
    const val activityKtx = "androidx.activity:activity-ktx:1.7.0"

    //https://github.com/kirich1409/ViewBindingPropertyDelegate
    const val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate:1.5.9"
}