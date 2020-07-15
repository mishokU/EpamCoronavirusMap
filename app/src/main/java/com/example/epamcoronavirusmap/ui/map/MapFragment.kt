package com.example.epamcoronavirusmap.ui.map

import android.content.Context
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*
import javax.inject.Inject
import com.example.epamcoronavirusmap.api.map.CountryModel
import com.example.epamcoronavirusmap.ui.base.BaseContract

class MapFragment : BaseFragment(), MapContract.View, OnMapReadyCallback {

    @Inject
    lateinit var presenter: MapContract.Presenter

    private var mMap: GoogleMap? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_map
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun displayCountries(countries: List<String>) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        map_view.onCreate(null)
        map_view.onResume()
        map_view.getMapAsync(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.loadCountries()
    }

    override fun showCountriesOnMap(countries: List<CountryModel>) {
        for (country in countries) {
            mMap.addCircle()
        }
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

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            val coordinates = LatLng(60.056862, 30.477511)
            mMap = it
            mMap?.apply {
                addMarker(MarkerOptions().position(coordinates).title("Novoe Dev"))
                moveCamera(CameraUpdateFactory.newLatLng(coordinates))
            }
        }
    }
}
