package com.example.epamcoronavirusmap.ui.statistics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.countries.CountryResponse
import kotlinx.android.synthetic.main.activity_recycler_item.view.*


class StatisticsRecyclerViewAdapter() : RecyclerView.Adapter<StatisticsRecyclerViewAdapter.CountryViewHolder>() {
    private var countryStatisticsList: MutableList<CountryResponse> = mutableListOf()

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val news = countryStatisticsList[position]
        holder.bindNews(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_item, parent, false)
        return CountryViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = countryStatisticsList.size

    fun setPosts(countryStatistics: List<CountryResponse>) {
        this.countryStatisticsList = countryStatistics.toMutableList()
        notifyDataSetChanged()
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindNews(country: CountryResponse) {
            itemView.text_country_name?.text = country.countryName
            itemView.total_cases?.text =
                country.totalCases.toString() + " (+" + country.todayCases.toString() + ")"
            itemView.dead_cases?.text =
                country.totalDeaths.toString() + " (+" + country.todayDeaths.toString() + ")"
            itemView.recovered_cases?.text = country.recoveredCases.toString()
        }
    }
}

