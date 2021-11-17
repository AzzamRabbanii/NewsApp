package com.azzam.newsapp

import android.content.Intent
import com.azzam.newsapp.data.DataNews
import com.azzam.newsapp.databinding.NewsHeadlineBinding


fun bindNewsHeadLine(binding: NewsHeadlineBinding, position: Int) {
    binding.apply {
        imgHeadline.setImageResource(DataNews.photoHeadline[position])
        tvTitleHeadline.text = DataNews.titleHeadline[position]
        tvDescHeadline.text = DataNews.contentHeadline[position]
        tvAuthorHeadline.text = DataNews.authorHeadline[position]
        tvDateHeadline.text = DataNews.dateHeadline[position]
    }

    binding.root.setOnClickListener {
        val intentToDetail = Intent(binding.root.context, DetailActivity::class.java)
        intentToDetail.putExtra(DetailActivity.EXTRA_IMG_HEADLINE, DataNews.photoHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_TITLE_HEADLINE, DataNews.titleHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_CONTENT_HEADLINE, DataNews.contentHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_DATE_HEADLINE, DataNews.dateHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_AUTHOR_HEADLINE, DataNews.authorHeadline[position])

        binding.root.context.startActivity(intentToDetail)
    }

}