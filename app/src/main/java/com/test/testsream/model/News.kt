package com.test.testsream.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News (
    @Json(name="status")
    val status: String? = null,
    @Json(name="copyright")
    val copyright: String? = null,
    @Json(name="section")
    val section: String? = null,
    @Json(name="last_updated")
    val lastUpdated: String? = null,
    @Json(name="num_results")
    val numResults: Int? = null,
    @Json(name="results")
    val results: List<NewsResult>? = null
    )
