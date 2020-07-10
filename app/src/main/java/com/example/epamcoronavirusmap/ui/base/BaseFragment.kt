package com.example.epamcoronavirusmap.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment(), BaseContract.View {

    private var basePresenter: BaseContract.Presenter<BaseContract.View>? = null
    private var rootView: View? = null

    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false)
            basePresenter = initBasePresenter()
            basePresenter?.attach(this)
        }
        return rootView
    }

    abstract fun initBasePresenter(): BaseContract.Presenter<BaseContract.View>

    override fun onDestroy() {
        super.onDestroy()
        basePresenter?.unsubscribe()
    }
}