package com.example.listpopularmoviesp.main;

import com.example.listpopularmoviesp.ActivityScope;
import com.example.listpopularmoviesp.AppComponent;


import dagger.Component;

/**
 * Created by polbins on 25/02/2017.
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
interface MainComponent {

    void inject (MainActivity mainActivity);

}
