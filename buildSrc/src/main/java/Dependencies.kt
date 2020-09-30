const val kotlinVersion = "1.3.72"

object Config {
    const val applicationId = "com.android.imdb"
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.2"
        const val hiltDaggerGradle = "2.28-alpha"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltDaggerGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltDaggerGradle}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHiltAndroid = "dagger.hilt.android.plugin"
}


object AndroidSdk {
    const val min = 16
    const val compile = 29
    const val target = compile
    const val buildToolsVersion = "30.0.1"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.1.0"
        const val constraintLayout = "1.1.2"
        const val ktx = "1.3.1"
        const val swipeRefreshLayout = "1.1.0"
        const val recyclerView = "1.1.0"
        const val multidex = "1.0.3"
        const val material = "1.0.0"
        const val fragmentKTX = "1.2.5"
        const val viewModelLifecycle = "2.2.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val multidex = "com.android.support:multidex:${Versions.multidex}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val fragmentKTX = "androidx.fragment:fragment-ktx:${Versions.fragmentKTX}"
    const val viewModelLifecycle =
        "androidx.lifecycle:lifecycle-viewmodel:${Versions.viewModelLifecycle}"
}

object APILibraries {

    object Versions {
        const val retrofit = "2.6.0"
        const val retrofitConverterMoshi = "2.4.0"
        const val moshi = "1.9.2"
        const val moshiKotlin = "1.9.2"
        const val moshiAdapters = "1.5.0"
        const val retrofitRXJava3 = "3.0.0"
        const val loggingInterceptor = "3.12.1"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRXJava3 =
        "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.retrofitRXJava3}"
    const val retrofitConverterMoshi =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofitConverterMoshi}"
    const val moshi = "com.squareup.moshi:moshi:$${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshiAdapters}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}


object DILibraries {

    object Versions {
        const val hiltAndroid = "2.28-alpha"
        const val hiltAndroidCompiler = "2.28-alpha"
        const val hiltCompiler = "1.0.0-alpha01"
        const val hiltViewModel = "1.0.0-alpha01"
    }

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"

}

object RXLibraries {

    object Versions {
        const val rxJava = "3.0.4"
        const val rxAndroid = "3.0.0"
    }

    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"
}


object ImageLoaderLibraries{

    object Versions{
        const val coil = "1.0.0-rc3"
    }


    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object TestLibraries {

    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.1.0-alpha4"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}


