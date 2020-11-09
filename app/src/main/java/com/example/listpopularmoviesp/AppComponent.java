package com.example.listpopularmoviesp;

import android.app.Application;


import com.example.listpopularmoviesp.api.ApiModule;
import com.example.listpopularmoviesp.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by polbins on 25/02/2017.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface AppComponent {

    Application application();

    ApiService apiService();

    void inject(App app);

}
