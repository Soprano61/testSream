package com.test.testsream.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class NewsResult (

    @Json(name="section")
    val section: String? = null,
    @Json(name="subsection")
    val subsection: String? = null,
    @Json(name="title")
    val title: String? = null,
    @Json(name="abstract")
    val abstract: String? = null,
    @Json(name="url")
    val url: String? = null,
    @Json(name="byline")
    val byline: String? = null,
    @Json(name="item_type")
    val itemType: String? = null,
    @Json(name="updated_date")
    val updatedDate: String? = null,
    @Json(name="created_date")
    val createdDate: String? = null,
    @Json(name="published_date")
    val publishedDate: String? = null,
    @Json(name="material_type_facet")
    val materialTypeFacet: String? = null,
    @Json(name="kicker")
    val kicker: String? = null,
    @Json(name="des_facet")
    val desFacet: List<String>? = null,
    @Json(name="short_url")
    val shortUrl: String? = null,
    @Json(name="org_facet")
    val orgFacet: List<String>? = null,
    @Json(name="per_facet")
    val perFacet: List<String>? = null,
    @Json(name="geo_facet")
    val geoFacet: List<String>? = null,
    @Json(name="multimedia")
    val multimedia: List<Multimedium>? = null
)