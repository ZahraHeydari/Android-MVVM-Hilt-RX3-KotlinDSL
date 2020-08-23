plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHiltAndroid)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = TestLibraries.AndroidJunitRunner

        multiDexEnabled = true

        viewBinding{
            isEnabled = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}


dependencies {

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.swipeRefreshLayout)
    implementation(Libraries.recyclerView)
    implementation(Libraries.multidex)

    implementation(APILibraries.retrofit)
    implementation(APILibraries.retrofitConverterMoshi)
    implementation(APILibraries.moshi)
    implementation(APILibraries.moshiKotlin)
    implementation(APILibraries.moshiAdapters)

    implementation(DILibraries.hiltAndroid)
    kapt(DILibraries.hiltAndroidCompiler)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}