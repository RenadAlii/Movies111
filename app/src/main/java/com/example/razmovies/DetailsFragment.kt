package com.example.razmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.razmovies.databinding.FragmentDetailsBinding
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
        val fragmentBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            LANGUAGEOFMOVIE = it.getString(language).toString()
            OVERVIEWOFMOVIE = it.getString(overview).toString()
            POSTEROFMOVIE = it.getString(poster).toString()
            TITLEOFMOVIE = it.getString(title).toString()


        }
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}