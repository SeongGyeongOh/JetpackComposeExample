package com.osg.jetpackcomposeexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitService {
    @Headers("Accept: application/json")
    @GET("api/v1/classes/")
    fun getData() : Call<ArrayList<ClassElement>>

}