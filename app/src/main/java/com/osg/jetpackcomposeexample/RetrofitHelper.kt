package com.osg.jetpackcomposeexample

//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

public class RetrofitHelper {
//    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun getRetrofit(): Retrofit {
        val builder=Retrofit.Builder()
        builder.baseUrl("https://api.mastersdirection.com/")
        builder.addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }

}