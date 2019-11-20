package com.test.testsream.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.test.testsream.R
import com.test.testsream.model.NewsResult
import com.test.testsream.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var mainViewModel: MainViewModel? = null
    var mNewsAdapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        getPopularNews()
        swiperefresh.setOnRefreshListener { getPopularNews() }
    }

    fun getPopularNews() {
        swiperefresh.setRefreshing(false)
        mainViewModel!!.allNews.observe(this, Observer {  newsList ->
            prepareRecyclerView(newsList)
        })

    }

    private fun prepareRecyclerView(newsList: List<NewsResult>?) {

        mNewsAdapter = NewsAdapter(newsList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            newsRecyclerView.setLayoutManager(LinearLayoutManager(this))
        } else {
            newsRecyclerView.setLayoutManager(GridLayoutManager(this, 4))
        }
        newsRecyclerView.setItemAnimator(DefaultItemAnimator())
        newsRecyclerView.setAdapter(mNewsAdapter)

    }
}
