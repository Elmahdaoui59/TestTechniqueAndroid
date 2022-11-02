package com.eldevs.githubusers.di

import com.eldevs.githubusers.data.remote.GithubApi
import com.eldevs.githubusers.data.repository.UserRepository
import com.eldevs.githubusers.data.repository.UserRepositoryImpl
import com.eldevs.githubusers.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(api: GithubApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApi(): GithubApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GithubApi::class.java)
    }

}