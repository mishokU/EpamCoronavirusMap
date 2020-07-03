package com.example.epamcoronavirusmap.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.epamcoronavirusmap.databinding.FragmentMapBinding
import com.example.epamcoronavirusmap.domain.Result
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MapFragment : DaggerFragment(), MapView {

    private lateinit var binding : FragmentMapBinding

    @Inject
    lateinit var presenter: MapPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onBind(this)
    }

    private fun showProgress(show: Boolean) {
        if(show) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun showErrorMessage(error : Result.Error?) {
        binding.errorText.isVisible = error != null
        binding.errorText.text = error?.exception?.message
    }

    private fun loadCountiesData(countries: List<String>) {
        //Timber.d("countries", countries)
    }

    override fun update(result: MapResult) {
        when(result){
            is Result.Success -> loadCountiesData(result.data)
        }
        showErrorMessage(result as? Result.Error)
        showProgress(result is Result.Loading)
    }


}
