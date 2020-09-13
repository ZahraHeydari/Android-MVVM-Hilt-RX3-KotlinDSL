package com.android.imdb.di

import android.os.Build
import com.android.imdb.BuildConfig
import com.android.imdb.data.source.APIService
import com.android.imdb.utils.AppConstants
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {


    private const val TIME_OUT = 30L


    @Provides
    fun createRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun createOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            }
            client.addNetworkInterceptor(interceptor)
        }
        client.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .headers(getJsonHeader())
                .build()
            chain.proceed(request)
        }
            .build()
        return client.build()
    }

    private fun getJsonHeader(): Headers {
        val builder = Headers.Builder().apply {
            add("Content-Type", "application/json")
            add("Accept", "application/json")
            add(
                "User-Agent",
                "${BuildConfig.VERSION_NAME};${Build.MANUFACTURER};${Build.MODEL};Android-${Build.VERSION.RELEASE}"
            )
        }
        return builder.build()
    }

    @Provides
    fun createMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()

    @Provides
    fun createMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    fun createService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

}