package com.test.testsream.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Multimedium (

    @Json(name="url")
    val url: String? = null,
    @Json(name="format")
    val format: String? = null,
    @Json(name="height")
    val height: String? = null,
    @Json(name="width")
    val width: String? = null,
    @Json(name="type")
    val type: Int? = null,
    @Json(name="subtype")
    val subtype: Int? = null,
    @Json(name="caption")
    val caption: Int? = null,
    @Json(name="copyright")
    val copyright: Int? = null,
    @Json(name="results")
    val results: List<NewsResult>? = null
)