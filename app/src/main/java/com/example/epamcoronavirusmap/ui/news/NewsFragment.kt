package com.example.epamcoronavirusmap.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.api.news.model.NewsPost
import com.example.epamcoronavirusmap.databinding.FragmentNewsBinding
import com.example.epamcoronavirusmap.domain.Result
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/*
    Вам нужно будет написать Presenter + View, реализовать, как у меня в примере
    Также написать адаптер для RecyclerView
*/

class NewsFragment : DaggerFragment(), NewsView {

    private lateinit var binding: FragmentNewsBinding

    @Inject
    lateinit var presenter: NewsPresenter

    private lateinit var recyclerView: RecyclerView
    private var adapter: NewsRecyclerViewAdapter = NewsRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onBind(this)

        recyclerView = view.findViewById(R.id.newsRecyclerView)
        setupRecyclerView()
    }

    private fun showProgress(show: Boolean) {
        if (show) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun showErrorMessage(error: Result.Error?) {
        binding.errorText.isVisible = error != null
        binding.errorText.text = error?.exception?.message
    }

    private fun loadNewsData(news: List<NewsPost>?) {
        news.let {
            adapter.setPosts(it!!)
        }
    }

    override fun update(result: NewsResult) {
        when (result) {
            is Result.Success -> loadNewsData(result.data?.news)
        }
        showErrorMessage(result as? Result.Error)
        showProgress(result is Result.Loading)
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }
}
