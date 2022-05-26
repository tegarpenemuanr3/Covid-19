package com.tegarpenemuan.covid_19.di

import com.tegarpenemuan.covid_19.data.api.CovidAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    //untuk inject object network yang dibutuhkan
    //modul-modul adalah kotak dimana ini nanti akan dipanggil secara berulang.

    //baseURL
    @Singleton
    @Provides
    fun provideBaseUrl() = "https://data.covid19.go.id/public/api/"

    //logging
    @Singleton
    @Provides
    fun provideHttpLogging(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    //Client
    @Singleton
    @Provides
    fun provideOkhttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    //Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    //Instance
    @Singleton
    @Provides
    fun provideCovidAPI(retrofit: Retrofit): CovidAPI {
        return retrofit.create(CovidAPI::class.java)
    }
}