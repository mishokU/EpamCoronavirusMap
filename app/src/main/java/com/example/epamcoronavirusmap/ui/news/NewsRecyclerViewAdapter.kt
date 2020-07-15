package com.example.epamcoronavirusmap.ui.news

//import com.squareup.picasso.Picasso
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.epamcoronavirusmap.R
import com.example.epamcoronavirusmap.api.news.model.Image
import com.example.epamcoronavirusmap.api.news.model.NewsPost
import com.example.epamcoronavirusmap.ui.base.BaseFragment
import kotlinx.android.synthetic.main.news_post_recycler_view_item.view.*

class NewsRecyclerViewAdapter(
    fragment: BaseFragment
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {

    private var news: MutableList<NewsPost> = mutableListOf()

    private val listener: OnItemClickListener

    init {
        listener = fragment as OnItemClickListener
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = news[position]
        holder.bindNews(news)
//        holder.view.setOnClickListener {
//            listener.onItemClick(news.webUrl)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_post_recycler_view_item, parent, false)
        return NewsViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = news.size

    fun setPosts(news: List<NewsPost>) {
        this.news = news.toMutableList()
        notifyDataSetChanged()
    }

    class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var news: NewsPost? = null

        fun bindNews(news: NewsPost) {
            this.news = news
            view.newsTitle.text = news.title
            view.newsExcerpt.text = news.excerpt

            val imageInfo: Image? = news.images?.firstOrNull()
//            imageInfo?.url?.let {
//                Picasso.get()
//                    .load(it)
//                    .into(view.newsImage)
//            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(url: String)
    }
}