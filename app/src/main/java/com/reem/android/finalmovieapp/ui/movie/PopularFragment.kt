package com.reem.android.finalmovieapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.ui.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*


class PopularFragment: Fragment() {

    private lateinit var popularMoviesRecyclerView: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter



    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.popular_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       popularMoviesRecyclerView = view.findViewById(R.id.popular_movies)
        popularMoviesRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}



