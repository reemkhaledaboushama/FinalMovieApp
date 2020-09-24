package com.reem.android.finalmovieapp.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.squareup.picasso.Picasso

class PopularFragment : Fragment() {

    private lateinit var generalView: View
    private lateinit var popularMoviesRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        generalView = View.inflate(context,R.layout.popular_fragment, null)
        return generalView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularMoviesRecyclerView = view.findViewById(R.id.movies_recycler_view)

        popularMoviesRecyclerView.layoutManager=LinearLayoutManager(context)
    }

    class MoviesAdapter (private val movies: List<Movie>) :
            RecyclerView.Adapter<MoviesAdapter.PopularMoviesViewHolder>() {

            inner class PopularMoviesViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

                private val movieTitleTextView: TextView =
                    itemView.findViewById(R.id.movie_title_text_view)
                private val movieRatingTextView: TextView = itemView.findViewById(R.id.movie_rating)
                private val movieReleaseDateTextView: TextView =
                    itemView.findViewById(R.id.movie_release_date)
                private val movieLanguageTextView: TextView = itemView.findViewById(R.id.movie_language)
                private val movieImageView: ImageView = itemView.findViewById(R.id.movie_image_view)

                @SuppressLint("SetTextI18n")
                fun bind(movie: Movie) {
                    movieTitleTextView.text = movie.title
                    movieRatingTextView.text = "${movie.vote_average}/10"
                    movieReleaseDateTextView.text = movie.release_date
                    movieLanguageTextView.text = movie.original_language

                    val url = "https://image.tmdb.org/t/p/w500".plus(movie.poster_path)

                    Picasso.get()
                        .load(url)
                        .placeholder(R.drawable.ic_loading)
                        .into(movieImageView)
                }

            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
            val cardView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false) as CardView
            return PopularMoviesViewHolder(cardView)
        }

        override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
            val movie = movies[holder.adapterPosition]
            holder.bind(movie)
        }

        override fun getItemCount(): Int {
            return movies.size
        }
    }


}