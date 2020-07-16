package com.example.epamcoronavirusmap.ui.histogram

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.api.Constants
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_daily_statistics.*
import kotlinx.android.synthetic.main.fragment_map.errorText
import kotlinx.android.synthetic.main.fragment_map.progressBar
import javax.inject.Inject

class DailyStatisticsFragment : BaseFragment(), DailyStatisticsContract.View {

    @Inject
    lateinit var presenter: DailyStatisticsContract.Presenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_daily_statistics
    }

    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeArgs = DailyStatisticsFragmentArgs.fromBundle(it)
            presenter.loadStatistics(safeArgs.country)
            titleTextView.text = safeArgs.country + Constants.DAILY_GROWTH_STRING
        }
    }

    override fun setBarChartData(growth: List<Float>, date: List<String>) {
        histogram.setData(growth, date)
    }

    override fun showProgress() {
        progressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = INVISIBLE
    }

    override fun showError(error: String) {
        errorText.text = error
    }

}
