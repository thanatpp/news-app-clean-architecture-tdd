package com.thanatpp.newsapp.di

import com.thanatpp.newsapp.data.DataSource
import com.thanatpp.newsapp.data.NewsDataSource
import com.thanatpp.newsapp.data.NewsRepository
import com.thanatpp.newsapp.data.network.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(dataSource: NewsDataSource): NewsRepository {
        return NewsRepository(dataSource)
    }
}