package com.example.listpopularmoviesp.main;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.listpopularmoviesp.R;
import com.example.listpopularmoviesp.model.Images;
import com.example.listpopularmoviesp.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by polbins on 25/02/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Activity activity;
    private Images images;
    private ItemClickListener itemClickListener;

    public MoviesAdapter(List<Movie> movies, Activity activity, Images images, ItemClickListener itemClickListener) {
        this.movies = movies;
        this.activity = activity;
        this.images = images;
        this.itemClickListener = itemClickListener;
    }

    public MoviesAdapter(RecyclerView contentView) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = movies.get(position);

        String fullImageUrl = getFullImageUrl(movie);
        if (!fullImageUrl.isEmpty()) {
            Glide.with(activity)
                    .load(fullImageUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .transition(withCrossFade())
                    .into(holder.imageView);
        }

        String popularity = getPopularityString(movie.popularity);
        holder.popularityTextView.setText(popularity);
        holder.titleTextView.setText(movie.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(movie.id, movie.title);
            }
        });
    }

    @NonNull
    private String getFullImageUrl(Movie movie) {
        String imagePath;

        if (movie.posterPath != null && !movie.posterPath.isEmpty()) {
            imagePath = movie.posterPath;
        } else {
            imagePath = movie.backdropPath;
        }

        if (images != null && images.baseUrl != null && !images.baseUrl.isEmpty()) {
            if (images.posterSizes != null) {
                if (images.posterSizes.size() > 4) {
                    // usually equal to 'w500'
                    return images.baseUrl + images.posterSizes.get(4) + imagePath;
                } else {
                    // back-off to hard-coded value
                    return images.baseUrl + "w500" + imagePath;
                }
            }
        }

        return "";
    }

    @Override
    public int getItemCount() {
        //return movies.size();
        return 10;
    }

    public void clear() {
        movies.clear();
    }

    public void addAll(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    public void setImages(Images images) {
        this.images = images;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.popularityTextView)
        TextView popularityTextView;
        @BindView(R.id.titleTextView)
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

    }

    private String getPopularityString(float popularity) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.#");
        return decimalFormat.format(popularity);
    }

    public interface ItemClickListener {

        void onItemClick(int movieId, String title);

    }

}
