package com.test.testsream.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.testsream.model.NewsResult


class MainViewModel() : ViewModel() {

    val movieRepository= NewsRepository()
    val allNews: MutableLiveData<List<NewsResult>> get() = movieRepository.getMutableLiveData()

    override fun onCleared() {
        super.onCleared()
        movieRepository.completableJob.cancel()
    }
}