package com.test.testsream.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.test.testsream.model.NewsResult
import com.test.testsream.networking.RestApiService
import kotlinx.coroutines.*
import retrofit2.HttpException

class NewsRepository() {

    private var movies = listOf<NewsResult>()
    private var mutableLiveData = MutableLiveData<List<NewsResult>>()
    private val CATEGORY = "science"
    private val API_KEY = "9Fv4jkjJ0iy0wIEp1XyuL0V5d95w0RUf"

    val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val thisApiService by lazy {
        RestApiService.createService()
    }

    fun getMutableLiveData():MutableLiveData<List<NewsResult>> {
        coroutineScope.launch {
            val request = thisApiService.getNowWeather(CATEGORY,API_KEY)
            withContext(Dispatchers.Main) {
                try {
                    val newsWrapper = request.await()
                    if (newsWrapper.results != null) {
                        movies = newsWrapper.results as MutableList<NewsResult>
                        mutableLiveData.value=movies
                    }

                } catch (e: HttpException) {
                    // Log exception //
                } catch (e: Throwable) {
                    // Log error //)
                }
            }
        }
        return mutableLiveData
    }
}