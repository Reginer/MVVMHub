/**
 * @author :Reginer in  19-6-18 下午3:50.
 * 联系方式:QQ:282921012
 * 功能描述:环境变量
 */
object AppConfig {
    const val versionName = "1.0"
    const val versionCode = 1
    const val applicationId = "win.regin.mvvm"
    const val buildToolsVersion = "29.0.0"
    const val compileSdkVersion = 28
    const val targetSdkVersion = 28
    const val minSdkVersion = 23
}

object Version {
    const val gradleVersion = "3.5.0"
    const val kotlinVersion = "1.3.41"
    const val appcompatVersion = "1.1.0-rc01"
    const val ktxVersion = "1.2.0-alpha02"
    const val constraintlayoutVersion = "2.0.0-beta2"
    const val junitVersion = "4.12"
    const val extUnitVersion = "1.1.0"
    const val espressoVersion = "3.2.0"
    const val lifecycleVersion = "2.2.0-alpha03"
    const val retrofitVersion = "2.6.0"
    //http://jcenter.bintray.com/org/jetbrains/kotlinx/kotlinx-coroutines-android/
    const val coroutinesVersion = "1.3.0-RC"
    //http://jcenter.bintray.com/com/squareup/okhttp3/logging-interceptor/
    const val okhttp3LogVersion = "4.0.1"
    //http://jcenter.bintray.com/org/jetbrains/anko/anko-commons/
    const val ankoVersion = "0.10.8"
    const val materialVersion = "1.1.0-alpha08"
    const val objectboxVersion  = "2.3.4"
    const val loggerVersion  = "2.2.0"
}

object MvvmExt {
    const val buildGradle = "com.android.tools.build:gradle:${Version.gradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val ktx = "androidx.core:core-ktx:${Version.ktxVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"
    const val junit = "junit:junit:${Version.junitVersion}"
    const val extUnit = "androidx.test.ext:junit:${Version.extUnitVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espressoVersion}"
    //https://developer.android.google.cn/jetpack/androidx/releases/lifecycle#declaring_dependencies
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleVersion}"
    //https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3LogVersion}"
    //https://github.com/Kotlin/kotlinx.coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}"
    const val anko = "org.jetbrains.anko:anko-commons:${Version.ankoVersion}"
    const val material = "com.google.android.material:material:${Version.materialVersion}"

    // https://github.com/objectbox/objectbox-java
    const val objectboxProcessor = "io.objectbox:objectbox-processor:${Version.objectboxVersion}"
    const val objectboxKotlin = "io.objectbox:objectbox-kotlin:${Version.objectboxVersion}"
    const val objectboxAndroid = "io.objectbox:objectbox-android:${Version.objectboxVersion}"
    const val objectboxGradlePlugin = "io.objectbox:objectbox-gradle-plugin:${Version.objectboxVersion}"
    //https://github.com/orhanobut/logger
    const val logger =  "com.orhanobut:logger:${Version.loggerVersion}"
}