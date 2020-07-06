package com.example.epamcoronavirusmap.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.epamcoronavirusmap.databinding.FragmentMapBinding
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import javax.inject.Inject

class MapFragment : BaseFragment(), MapContract.View {

    private lateinit var binding : FragmentMapBinding

    @Inject
    lateinit var presenter: MapContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater)
        return binding.root
    }

    override fun getLayoutId(): Int {
        return binding.root.id
    }

    override fun displayCountries(countries: List<String>) {
        TODO("Not yet implemented")
    }

    override fun showCountry(country: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(message: String?) {
        binding.errorText.text = message
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showError() {
        binding.errorText.visibility = View.VISIBLE
    }


}
