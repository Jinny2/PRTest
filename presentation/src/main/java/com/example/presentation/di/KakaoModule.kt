package com.example.presentation.di

import android.content.Context
import com.example.data.KakaoRepositoryImpl
import com.example.data.repository.KakaoDataSource
import com.example.data.repository.KakaoDataSourceImpl
import com.example.domain.repository.KakaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KakaoModule {

    @Singleton
    @Provides
    fun mdKakaoDataSource(@ApplicationContext appContext: Context): KakaoDataSource {
        return KakaoDataSourceImpl(appContext)
    }

    @Singleton
    @Provides
    fun mdKakaoRepository(kakaoDataSource: KakaoDataSource): KakaoRepository {
        return KakaoRepositoryImpl(kakaoDataSource)
    }
}