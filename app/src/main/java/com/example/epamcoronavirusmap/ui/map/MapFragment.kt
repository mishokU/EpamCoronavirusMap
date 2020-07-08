package com.example.epamcoronavirusmap.ui.map

import android.view.View
import com.example.epamcoronavirusmap.R
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.epamcoronavirusmap.databinding.FragmentMapBinding
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_map.*
import javax.inject.Inject

class MapFragment : BaseFragment(), MapContract.View {

    @Inject
    lateinit var presenter: MapContract.Presenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_map
    }

    override fun displayCountries(countries: List<String>) {
        TODO("Not yet implemented")
    }

    override fun showCountry(country: String) {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showError(error: String) {
        errorText.text = error
    }
}
