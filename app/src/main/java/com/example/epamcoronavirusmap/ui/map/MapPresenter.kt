package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.domain.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


typealias MapResult = Result<List<String>>

class MapPresenter(private val api : CoronavirusApi) {

    private var coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private var result : MapResult = Result.Loading
    private lateinit var view: MapView

    init {
        loadCountries()
    }

    fun onBind(view : MapView){
        this.view = view
    }

    private fun loadCountries() {
        coroutineScope.launch {
            val dataAsync = api.getTestData()
            try {
                val data = dataAsync.await()
                updateView { Result.Loading }
                if(!data.isNullOrEmpty()){
                    updateView { Result.Success(data) }
                }
            } catch (e : Exception){
                updateView { Result.Error(e) }
            }
        }
    }

    private fun updateView(mapper : MapResult.() -> MapResult) {
        result = result.mapper()
        view.update(result)
    }
}