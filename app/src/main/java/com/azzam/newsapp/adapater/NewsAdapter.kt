package com.azzam.newsapp.adapater

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azzam.newsapp.DetailActivity
import com.azzam.newsapp.data.News
import com.azzam.newsapp.databinding.RowItemNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val ItemNewsBinding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(ItemNewsBinding.root) {

        fun bindItem(news: News) {
            ItemNewsBinding.tvCategory.text = news.category
            ItemNewsBinding.tvTitle.text = news.tittle
            ItemNewsBinding.tvDate.text = news.date
            ItemNewsBinding.tvTime.text = news.time
            ItemNewsBinding.imgNews.setImageResource(news.photo)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(listNews[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.NEWS_DATA, listNews[position])
            it.context.startActivity(intent)

        }
    }

    override fun getItemCount() = listNews.size


}