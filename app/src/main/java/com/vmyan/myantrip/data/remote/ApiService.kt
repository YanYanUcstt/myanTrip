package com.vmyan.myantrip.data.remote

import com.vmyan.myantrip.data.entities.Place
import com.vmyan.myantrip.data.entities.PlaceCategory
import com.vmyan.myantrip.data.entities.SubPlaceCategory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/myanTrip/public/api/sub_place_categories")
    suspend fun getAllSubPlaceCategory() : Response<List<SubPlaceCategory>>

    @GET("/myanTrip/public/api/place_categories")
    suspend fun getAllPlaceCategory() : Response<List<PlaceCategory>>

    @GET("/myanTrip/public/api/places")
    suspend fun getAllPlace() : Response<List<Place>>

    @GET("/myanTrip/public/api/places/isRecommended/true")
    suspend fun getRecommendedPlace() : Response<List<Place>>

    @GET("/myanTrip/public/api/places/topRating")
    suspend fun getTopRatingPlace() : Response<List<Place>>

    @GET("/myanTrip/public/api/places/subCategory/{name}")
    suspend fun getSubCategoryPlaces(@Path("name") name: String) : Response<List<Place>>
}