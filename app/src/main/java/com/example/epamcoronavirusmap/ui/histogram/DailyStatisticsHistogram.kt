package com.example.epamcoronavirusmap.ui.histogram

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.getFloatOrThrow
import com.example.epamcoronavirusmap.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class DailyStatisticsHistogram(
    context: Context,
    attrs: AttributeSet
) : BarChart(context, attrs) {

    private var xRangeMaximum: Float? = null

    init {
        context.obtainStyledAttributes(attrs, R.styleable.DailyStatisticsHistogram)
            .apply {
                try {
                    legend.isEnabled =
                        getBoolean(R.styleable.DailyStatisticsHistogram_legendEnabled, true)
                    description.isEnabled =
                        getBoolean(R.styleable.DailyStatisticsHistogram_descriptionEnabled, true)
                    xAxis.setDrawGridLines(
                        getBoolean(
                            R.styleable.DailyStatisticsHistogram_xAxisGridLines,
                            true
                        )
                    )
                    axisRight.isEnabled =
                        getBoolean(R.styleable.DailyStatisticsHistogram_axisRightEnabled, true)
                    axisLeft.setDrawLabels(
                        getBoolean(
                            R.styleable.DailyStatisticsHistogram_axisLeftDrawLabels,
                            true
                        )
                    )
                    axisLeft.setDrawGridLines(
                        getBoolean(
                            R.styleable.DailyStatisticsHistogram_axisLeftGridLines,
                            true
                        )
                    )
                    axisLeft.setDrawAxisLine(
                        getBoolean(
                            R.styleable.DailyStatisticsHistogram_axisLeftAxisLines,
                            true
                        )
                    )
                    isScaleXEnabled =
                        getBoolean(R.styleable.DailyStatisticsHistogram_xAxisScaleEnabled, true)
                    isScaleYEnabled =
                        getBoolean(R.styleable.DailyStatisticsHistogram_yAxisScaleEnabled, true)
                    xRangeMaximum = try {
                        getFloatOrThrow(R.styleable.DailyStatisticsHistogram_xRangeMaximum)
                    } catch (e: Exception) {
                        null
                    }
                } finally {
                    recycle()
                }
            }
    }

    fun setData(growth: List<Float>, date: List<String>) {
        var count = 0f
        val entries = growth.map {
            val entry = BarEntry(count, it)
            count++
            entry
        }

        val dataset = BarDataSet(entries, "dataset")
        this.data = BarData(dataset)


        xAxis.valueFormatter = IndexAxisValueFormatter(date)
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xRangeMaximum?.let {
            setVisibleXRangeMaximum(it)
            moveViewToX(barData.xMax - it + barData.barWidth / 2.0f)
        }

        invalidate()
    }
}