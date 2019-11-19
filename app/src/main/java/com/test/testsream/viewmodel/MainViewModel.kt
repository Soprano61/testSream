package com.test.testsream.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.test.testsream.model.NewsResult


class MainViewModel() : ViewModel() {

    val movieRepository= NewsRepository()
    val allBlog: LiveData<List<NewsResult>> get() = movieRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        movieRepository.completableJob.cancel()
    }
}