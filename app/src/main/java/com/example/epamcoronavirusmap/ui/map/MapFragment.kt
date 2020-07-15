package com.example.epamcoronavirusmap.ui.map

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.fragment_map.*
import javax.inject.Inject


class MapFragment : BaseFragment(), MapContract.View, OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    @Inject
    lateinit var presenter: MapContract.Presenter

    private var mMap: GoogleMap? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_map
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        map_view.onCreate(null)
        map_view.onResume()
        map_view.getMapAsync(this)
    }

    override fun showCountriesOnMap(countries: List<MapUIModel>) {
        for (country in countries) {
            mMap?.addCircle(
                CircleOptions()
                    .center(LatLng(country.lat, country.lan))
                    .radius(country.mapCircle.first.toDouble())
                    .strokeColor(country.mapCircle.second)
                    .strokeWidth(2f)
                    .fillColor(Color.argb(70, 50, 50, 50))
            )
            mMap?.addMarker(
                MarkerOptions().position(LatLng(country.lat, country.lan))
                    .title(country.countryName)
                    .icon(BitmapDescriptorFactory.defaultMarker(country.markerColor))
            )
        }
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
            mMap = it
            mMap!!.setOnMarkerClickListener { marker ->
                onMarkerClick(marker)
            }
            presenter.loadCountries()
        }
    }

    // TODO: Just open histogram
    override fun onMarkerClick(marker: Marker?): Boolean {
        //val country = marker?.title


        return false
    }
}
