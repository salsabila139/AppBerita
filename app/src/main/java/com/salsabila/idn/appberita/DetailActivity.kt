package com.salsabila.idn.appberita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val cont_TitleNews = "cont_TitleNews"
        const val cont_PhotoNews = "cont_PhotoNews"
        const val cont_ContentNews = "cont_ContentNews"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        tv_titleNews.setText(intent.getStringExtra(cont_TitleNews))
        tv_contentNews.setText(intent.getStringExtra(cont_ContentNews))
        iv_toolbar.setImageResource(intent.getStringExtra(cont_PhotoNews)!!.toInt())

        iv_btnBack.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val toMain = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(toMain)
                finish()
            }
        })
    }
}