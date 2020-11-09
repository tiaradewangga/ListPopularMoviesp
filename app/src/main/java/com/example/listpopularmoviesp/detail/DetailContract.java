package com.example.listpopularmoviesp.detail;

import com.example.listpopularmoviesp.model.Images;
import com.example.listpopularmoviesp.model.Movie;

import java.util.List;

/**
 * Created by polbins on 25/02/2017.
 */

public interface DetailContract {

    interface View {

        void showLoading();

        void showContent(Movie movie);

        void showError();

        void onConfigurationSet(Images images);

    }

    interface Presenter {

        void start(int movieId);

        void finish();

    }

}
