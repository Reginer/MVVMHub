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
    const val gradleVersion = "3.4.1"
    const val kotlinVersion = "1.3.31"
    const val appcompatVersion = "1.0.2"
    const val ktxVersion = "1.0.2"
    const val constraintlayoutVersion = "1.1.3"
    const val junitVersion = "1.1.0"
    const val runnerVersion = "1.2.0"
    const val espressoVersion = "3.2.0"
    const val lifecycleVersion = "2.2.0-alpha01"
    const val retrofitVersion = "2.6.0"
    const val coroutinesVersion = "1.2.1"
    const val okhttp3LogVersion = "3.12.1"
}

object MvvmExt {
    const val buildGradle = "com.android.tools.build:gradle:${Version.gradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val ktx = "androidx.core:core-ktx:${Version.ktxVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"
    const val junit = "androidx.test.ext:junit:${Version.junitVersion}"
    const val runner = "androidx.test:runner:${Version.runnerVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espressoVersion}"
    //https://developer.android.google.cn/jetpack/androidx/releases/lifecycle#declaring_dependencies
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleVersion}"
    //https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3LogVersion}"
    //https://github.com/Kotlin/kotlinx.coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}"

}