package com.example.epamcoronavirusmap.ui.statistics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.ui.countries.CountryResponse


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
        private var mCountryNameView: TextView? = null
        private var mTotalCasesView: TextView? = null
        private var mDeadCasesView: TextView? = null
        private var mHealthyCasesView: TextView? = null

        init {
            mCountryNameView = itemView.findViewById(R.id.text_country_name)
            mTotalCasesView = itemView.findViewById(R.id.total_cases)
            mDeadCasesView = itemView.findViewById(R.id.dead_cases)
            mHealthyCasesView = itemView.findViewById(R.id.recovered_cases)
        }

        fun bindNews(country: CountryResponse) {
            mCountryNameView?.text = country.country
            mTotalCasesView?.text = country.cases.toString() + " (+" + country.todayCases.toString() + ")"
            mDeadCasesView?.text = country.deaths.toString() + " (+" + country.todayDeaths.toString() + ")"
            mHealthyCasesView?.text = country.recovered.toString()
        }
    }
}

