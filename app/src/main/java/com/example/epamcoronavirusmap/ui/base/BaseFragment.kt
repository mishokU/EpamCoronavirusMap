package com.example.epamcoronavirusmap.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment(), BaseContract.View {

    private var basePresenter: BaseContract.Presenter<BaseContract.View>? = null
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false)
            basePresenter?.attach(this)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        basePresenter?.unsubscribe()
    }
}