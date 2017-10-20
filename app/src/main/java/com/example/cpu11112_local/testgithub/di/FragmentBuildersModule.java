package com.example.cpu11112_local.testgithub.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Module
public abstract class FragmentBuildersModule {
    // create 3 subcomponent for 3 classes
    // not need any module
    @ContributesAndroidInjector
    abstract RepoFragment contributeRepoFragment();

    @ContributesAndroidInjector
    abstract UserFragment contributeUserFragment();

    @ContributesAndroidInjector
    abstract SearchFragment contributeSearchFragment();
}
