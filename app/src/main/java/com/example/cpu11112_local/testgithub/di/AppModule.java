package com.example.cpu11112_local.testgithub.di;

import com.example.cpu11112_local.testgithub.api.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {
    @Singleton
    @Provides
    GithubService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                // use livedata adapter or rxjava2 adapter
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
        // use okhttp client or not
                .build()
                .create(GithubService.class);
    }

    @Singleton
    @Provides
    GithubDb provideGithubDb() {

    }

    @Singleton
    @Provides
    UserDao provideUserDao() {

    }

    @Singleton
    @Provides
    RepoDao provideRepoDao() {

    }
}
