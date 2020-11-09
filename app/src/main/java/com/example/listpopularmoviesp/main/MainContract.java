package com.example.listpopularmoviesp.main;

import com.example.listpopularmoviesp.model.Images;
import com.example.listpopularmoviesp.model.Movie;

import java.util.List;

/**
 * Created by polbins on 25/02/2017.
 */

public interface MainContract {

    interface View {

        void showLoading(boolean isRefresh);

        void showContent(List<Movie> movies, boolean isRefresh);

        void showError();

        void onConfigurationSet(Images images);

    }

    interface Presenter {

        void start();

        void onPullToRefresh();

        void onScrollToBottom();

        void finish();

    }

}
