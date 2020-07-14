package com.example.epamcoronavirusmap.ui.news

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.api.news.model.NewsPost
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : BaseFragment(), NewsContract.View,
    NewsRecyclerViewAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: NewsContract.Presenter

    private var adapter: NewsRecyclerViewAdapter = NewsRecyclerViewAdapter(this)

    override fun getLayoutId(): Int {
        return R.layout.fragment_news
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
        progressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = INVISIBLE
    }

    override fun showError(error: String) {
        errorText.text = error
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    override fun displayPosts(posts: List<NewsPost>) {
        adapter.setPosts(posts)
    }

    override fun showPostFragment(url: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToPostFragment(url)
        findNavController().navigate(action)
    }

    override fun onItemClick(url: String) {
        presenter.onItemClick(url)
    }
}
