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
    val height: Int? = null,
    @Json(name="width")
    val width: Int? = null,
    @Json(name="type")
    val type: String? = null,
    @Json(name="subtype")
    val subtype: String? = null,
    @Json(name="caption")
    val caption: String? = null,
    @Json(name="copyright")
    val copyright: String? = null
)