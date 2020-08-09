package com.maxden.newsfeed.di.module

import com.maxden.newsfeed.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector
    abstract fun injectHomeFragment(): HomeFragment

}