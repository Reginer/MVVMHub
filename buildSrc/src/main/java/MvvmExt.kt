/**
 * @author :Reginer in  19-6-18 下午3:50.
 * 联系方式:QQ:282921012
 * 功能描述:环境变量
 */
object AppConfig {
    const val versionName = "1.0"
    const val versionCode = 1
    const val applicationId = "win.regin.mvvm"
    const val buildToolsVersion = "30.0.3"
    const val compileSdkVersion = 30
    const val targetSdkVersion = 30
    const val minSdkVersion = 21
    const val storePassword = "ly9999"
    const val keyAlias = "那时年少"
    const val storeFile = "../keystore/Young.jks"
}

object Version {
    const val gradleVersion = "4.2.1"
    const val kotlinVersion = "1.5.10"
    const val appcompatVersion = "1.2.0"
    const val ktxVersion = "1.3.2"
    const val constraintlayoutVersion = "2.0.4"
    const val junitVersion = "4.12"
    const val extUnitVersion = "1.1.0"
    const val espressoVersion = "3.2.0"
    const val retrofitVersion = "2.9.0"
    //http://jcenter.bintray.com/org/jetbrains/kotlinx/kotlinx-coroutines-android/
    const val coroutinesVersion = "1.5.0"
    //http://jcenter.bintray.com/com/squareup/okhttp3/logging-interceptor/
    const val okhttp3LogVersion = "4.9.1"
    const val materialVersion = "1.3.0"
    const val loggerVersion = "2.2.0"
    const val libVersionCode = 27
    const val libVersionName = "2.0.6"
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
    //https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
    //https://github.com/google/gson
    const val gson = "com.google.code.gson:gson:2.8.7"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3LogVersion}"
    //https://github.com/Kotlin/kotlinx.coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}"
    const val material = "com.google.android.material:material:${Version.materialVersion}"

    // https://github.com/objectbox/objectbox-java
    const val objectboxGradlePlugin = "io.objectbox:objectbox-gradle-plugin:2.9.2-RC"
    //https://github.com/orhanobut/logger
    const val logger = "com.orhanobut:logger:${Version.loggerVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.4"
    const val activityKtx = "androidx.activity:activity-ktx:1.2.3"

    //https://github.com/kirich1409/ViewBindingPropertyDelegate
    const val viewBinding ="com.github.kirich1409:viewbindingpropertydelegate:1.4.7"
}