package com.example.razmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.razmovies.adapter.MoviesAdapter
import com.example.razmovies.databinding.FragmentDetailsBinding
import com.example.razmovies.databinding.FragmentPopularMoviesBinding
import com.example.razmovies.model.MovieViewModel


class DetailsFragment : Fragment() {

    private val sharedViewModel: MovieViewModel by activityViewModels()
    private var binding: FragmentDetailsBinding? = null

    lateinit var TITLEOFMOVIE: String
    lateinit var POSTEROFMOVIE: String
    lateinit var OVERVIEWOFMOVIE: String
    lateinit var LANGUAGEOFMOVIE: String

    //to set the key in variable
    companion object {
        const val title = "originalTitle"
        const val language = "originalLanguage"
        const val poster = "posterPath"
        const val overview = "overview"

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater)

        binding?.apply {
            // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            //@ because inside binding.apply this revers to the binding instance
            // not the class DetailsFragment
            detailsFragment = this@DetailsFragment
        }
        return binding.root
    }






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            LANGUAGEOFMOVIE = it.getString(language).toString()
            OVERVIEWOFMOVIE = it.getString(overview).toString()
            POSTEROFMOVIE = it.getString(poster).toString()
            TITLEOFMOVIE = it.getString(title).toString()


        }

    }




}