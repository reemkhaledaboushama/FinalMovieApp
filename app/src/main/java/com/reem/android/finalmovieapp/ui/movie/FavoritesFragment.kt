package com.reem.android.finalmovieapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.data.repository.MoviesRepository
import com.reem.android.finalmovieapp.data.repository.MoviesRepository.dataBase
/*import com.reem.android.finalmovieapp.data.repository.MoviesRepository.getFavoriteMovies*/
import com.reem.android.finalmovieapp.ui.FavAdapter
import com.reem.android.finalmovieapp.ui.MoviesAdapter
import com.reem.android.finalmovieapp.ui.movie.popular.PopularViewModel
import kotlinx.android.synthetic.main.favorites_fragment.*
import kotlinx.android.synthetic.main.popular_fragment.*

class FavoritesFragment : Fragment() {

    /*  private val mainViewModel: FavoriteViewModel by viewModels()

      private lateinit var favMovies: RecyclerView
      private lateinit var favMoviesAdapter: MoviesAdapter
      private lateinit var favMoviesLayoutMgr: LinearLayoutManager
      private var favMoviesPage = 1*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        //favorites_fragment.adapter = FavAdapter(dataBase.getFavMoviesDao().getAllMovies()) { movie -> mainViewModel.getFavoriteMovies() }


        return inflater.inflate(R.layout.favorites_fragment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
