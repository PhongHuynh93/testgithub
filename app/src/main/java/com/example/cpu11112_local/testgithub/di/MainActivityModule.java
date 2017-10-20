package com.example.cpu11112_local.testgithub.di;

import com.example.cpu11112_local.testgithub.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Module
public abstract class MainActivityModule {
    // in main activity, we create fragment subcomponent
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
