package com.salsabila.idn.appberita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.salsabila.idn.appberita.newsadapter.NewsAdapter
import com.salsabila.idn.appberita.newsadapter.NewsModel
import com.salsabila.idn.appberita.newsadapter.news
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        var headline: news?
        if (NewsModel.newslist.size > 0){

            headline = NewsModel.newslist[NewsModel.newslist.size -2]
            tv_titleHeadline.setText(headline.title)
            tv_descHeadline.setText(headline.desc)
            iv_news.setImageResource(headline.photo)

            cv_headline.setOnClickListener{
                val detail_intent = Intent (this, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews, headline.title)
                        putExtra(DetailActivity.cont_ContentNews, headline.desc)
                        putExtra(DetailActivity.cont_PhotoNews, headline.photo)
                    }
                startActivity(detail_intent)
                finish()
            }
        }

        val recyclerView = LinearLayoutManager(this)
        recyclerView.orientation = LinearLayoutManager.VERTICAL
        rv_listNews.layoutManager = recyclerView

        newsAdapter = NewsAdapter(this, NewsModel.newslist)
        rv_listNews.adapter = newsAdapter

        newsAdapter.setOnClickCallback(object : NewsAdapter.onItemClickCallback {
            override fun onItemClick(data: news) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.cont_TitleNews, data.title)
                        putExtra(DetailActivity.cont_ContentNews, data.desc)
                        putExtra(DetailActivity.cont_PhotoNews, data.photo.toString())
                    }
                startActivity(intent)
                finish()
            }
        })
    }
}