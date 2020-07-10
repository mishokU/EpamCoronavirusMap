package com.example.epamcoronavirusmap.ui.map

import android.content.Context
import android.view.View
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.fragment_map.*
import javax.inject.Inject

class MapFragment : BaseFragment(), MapContract.View {

    @Inject
    lateinit var presenter: MapContract.Presenter

    private lateinit var mMap: GoogleMap

    override fun getLayoutId(): Int {
        return R.layout.fragment_map
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.loadCountries()
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun displayCountries(countries: List<String>) {

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
