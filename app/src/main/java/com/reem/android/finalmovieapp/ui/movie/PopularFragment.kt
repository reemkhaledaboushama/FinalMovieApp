package com.reem.android.finalmovieapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reem.android.finalmovieapp.R

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


}