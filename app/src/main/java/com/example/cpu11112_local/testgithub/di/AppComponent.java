package com.example.cpu11112_local.testgithub.di;

import android.app.Application;

import com.example.cpu11112_local.testgithub.GithubApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }

    void inject(GithubApp githubApp);
}
