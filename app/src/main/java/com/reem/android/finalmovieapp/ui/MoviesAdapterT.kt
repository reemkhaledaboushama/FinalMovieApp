package com.reem.android.finalmovieapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.data.models.ui.MovieT

class MoviesAdapterT (
    private var movies: MutableList<MovieT>,
    private val onMovieClick: (movie: MovieT) -> Unit
) : RecyclerView.Adapter<MoviesAdapterT.MovieViewHolderT>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolderT {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie_fragment, parent, false)
        return MovieViewHolderT(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolderT, position: Int) {
        holder.bind(movies[position])
    }


    inner class MovieViewHolderT(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)

        fun bind(movie: MovieT) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(poster)
            itemView.setOnClickListener { onMovieClick.invoke(movie) }

        }
    }
}