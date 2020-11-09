package com.example.listpopularmoviesp.main;

import com.example.listpopularmoviesp.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polbins on 25/02/2017.
 */

@Module
public class MainModule {
    private final MainContract.View mainView;

    MainModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    MainContract.View provideMainView() {
        return mainView;
    }

}

