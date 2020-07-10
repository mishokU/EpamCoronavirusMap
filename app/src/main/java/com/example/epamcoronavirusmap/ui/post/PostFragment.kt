package com.example.epamcoronavirusmap.ui.post

import android.os.Bundle
import android.view.View
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.errorText
import kotlinx.android.synthetic.main.fragment_news.progressBar
import kotlinx.android.synthetic.main.fragment_post.*
import javax.inject.Inject

class PostFragment : BaseFragment(), PostContract.View {

    @Inject
    lateinit var presenter: PostContract.Presenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_post
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeArgs = PostFragmentArgs.fromBundle(it)
            val postUrl = safeArgs.postUrl

            webView.loadUrl(postUrl)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun initBasePresenter(): BaseContract.Presenter<BaseContract.View> =
        presenter as BaseContract.Presenter<BaseContract.View>

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showError(error: String) {
        errorText.text = error
    }
}
