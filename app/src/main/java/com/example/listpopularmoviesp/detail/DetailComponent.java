package com.example.listpopularmoviesp.detail;

import com.example.listpopularmoviesp.ActivityScope;
import com.example.listpopularmoviesp.AppComponent;

import dagger.Component;

/**
 * Created by polbins on 25/02/2017.
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = DetailModule.class
)
interface DetailComponent {

    void inject(DetailActivity DetailActivity);

}
