package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MapPresenter : BasePresenter<MapContract.View>(), MapContract.Presenter {

    override fun onCountryClick(country: String) {
        view?.showCountry(country)
    }

    override fun loadCountries() {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitService.getTestData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view?.hideProgress() }
                .subscribe({
                    it?.let { view?.displayCountries(it) }
                }, { ex ->
                    view?.showError(ex.message.toString())
                    Timber.e(ex)
                })
        )
    }
}