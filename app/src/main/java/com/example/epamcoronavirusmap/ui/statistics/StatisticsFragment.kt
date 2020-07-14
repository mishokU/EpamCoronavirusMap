package com.example.epamcoronavirusmap.ui.statistics

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import com.example.epamcoronavirusmap.ui.countries.CountryResponse
import kotlinx.android.synthetic.main.fragment_statistics.*
import javax.inject.Inject

/*
    Вам нужно будет написать Presenter + View, реализовать, как у меня в примере
    Также написать тут появление для одной страны статистику, как я понял
*/

class StatisticsFragment : BaseFragment(), StatisticsContract.View {

    @Inject
    lateinit var presenter: StatisticsContract.Presenter

    private var adapter: StatisticsRecyclerViewAdapter = StatisticsRecyclerViewAdapter()

    override fun getLayoutId(): Int {
        return R.layout.fragment_statistics
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.loadPosts()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showError(error: String) {
        errorText.text = error
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    override fun displayPosts(posts: List<CountryResponse>) {
        adapter.setPosts(posts)
    }
}
