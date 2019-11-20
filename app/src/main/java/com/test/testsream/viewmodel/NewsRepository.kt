package com.test.testsream.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.test.testsream.model.Multimedium
import com.test.testsream.model.NewsResult
import com.test.testsream.networking.RestApiService
import kotlinx.coroutines.*
import retrofit2.HttpException

class NewsRepository() {

    private var movies = mutableListOf<NewsResult>()
    private var mutableLiveData = MutableLiveData<List<NewsResult>>()
    val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val thisApiCorService by lazy {
        RestApiService.createCorService()
    }

    fun getMutableLiveData():MutableLiveData<List<NewsResult>> {
        coroutineScope.launch {
            val request = thisApiCorService.getNowWeather("science","9Fv4jkjJ0iy0wIEp1XyuL0V5d95w0RUf")
            withContext(Dispatchers.Main) {
                try {

                    val response = request
                    val mNewsWrapper = response.await()
                    if (mNewsWrapper != null && mNewsWrapper.results != null) {
                        movies = mNewsWrapper.results as MutableList<NewsResult>
                        mutableLiveData.value=movies
                    }

                } catch (e: HttpException) {
                    // Log exception //

                } catch (e: Throwable) {
                    // Log error //)
                    val s = e
                }
            }
        }
        return mutableLiveData
    }
}