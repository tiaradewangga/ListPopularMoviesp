package com.example.listpopularmoviesp.detail;

import com.example.listpopularmoviesp.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polbins on 25/02/2017.
 */

@Module
public class DetailModule {
    private final DetailContract.View DetailView;

    DetailModule(DetailContract.View DetailView) {
        this.DetailView = DetailView;
    }

    @Provides
    @ActivityScope
    DetailContract.View provideDetailView() {
        return DetailView;
    }

}

