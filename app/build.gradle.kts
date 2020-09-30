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

        viewBinding {
            isEnabled = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
    implementation(Libraries.fragmentKTX)
    implementation(Libraries.viewModelLifecycle)

    implementation(APILibraries.retrofit)
    implementation(APILibraries.retrofitRXJava3)
    implementation(APILibraries.retrofitConverterMoshi)
    implementation(APILibraries.moshi)
    implementation(APILibraries.moshiKotlin)
    implementation(APILibraries.moshiAdapters)
    implementation(APILibraries.loggingInterceptor)

    implementation(RXLibraries.rxAndroid)
    implementation(RXLibraries.rxJava)

    implementation(DILibraries.hiltAndroid)
    implementation(DILibraries.hiltViewModel)
    kapt(DILibraries.hiltAndroidCompiler)
    kapt(DILibraries.hiltCompiler)

    implementation(ImageLoaderLibraries.coil)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}