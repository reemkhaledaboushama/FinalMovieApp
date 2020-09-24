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
import com.reem.android.finalmovieapp.viewmodels.TopRatedMoviesViewModel

class TopRatedFragment: Fragment() {

    private val topRatedMoviesViewModel: TopRatedMoviesViewModel by viewModels()
    private lateinit var generalView: View
    private lateinit var topRatedMoviesRecyclerView: RecyclerView
    private lateinit var topRatedMoviesAdapter: PopularFragment.MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generalView = View.inflate(context, R.layout.toprated_fragment, null)
        return generalView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRatedMoviesRecyclerView = view.findViewById(R.id.movies_recycler_view)

        topRatedMoviesRecyclerView.layoutManager = LinearLayoutManager(context)

        topRatedMoviesViewModel.topRatedMoviesLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                topRatedMoviesAdapter = PopularFragment.MoviesAdapter(it.shuffled())
                topRatedMoviesRecyclerView.adapter = topRatedMoviesAdapter
            })

    }
}