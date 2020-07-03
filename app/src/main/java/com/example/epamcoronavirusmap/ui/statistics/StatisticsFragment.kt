package com.example.epamcoronavirusmap.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.epamcoronavirusmap.R
import dagger.android.support.DaggerFragment

/*
    Вам нужно будет написать Presenter + View, реализовать, как у меня в примере
    Также написать тут появление для одной страны статистику, как я понял
*/

class StatisticsFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

}
