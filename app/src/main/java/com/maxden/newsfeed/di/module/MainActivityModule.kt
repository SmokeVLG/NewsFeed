package com.maxden.newsfeed.di.module

import com.maxden.newsfeed.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentInjectorsModule::class])
    abstract fun contributeMainActivity(): MainActivity
}