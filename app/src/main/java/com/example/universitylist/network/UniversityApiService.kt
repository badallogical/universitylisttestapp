package com.example.universitylist.network

import androidx.lifecycle.LiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "http://universities.hipolabs.com/"

// Moshi Object
val moshi = Moshi.Builder()
    .add( KotlinJsonAdapterFactory() )
    .build()

// Retrofit Object
val retrofit = Retrofit.Builder()
    .addConverterFactory( MoshiConverterFactory.create( moshi ) )
    .baseUrl(BASE_URL)
    .build()

interface UniversityApiService {

    @GET("search")
    suspend fun getUniversity( @Query("country") country : String ) : List<University>

}

// Singleton object for UniversityApiService
object UniversityApi{

    val retrofitService : UniversityApiService by lazy{
        retrofit.create( UniversityApiService::class.java)
    }

}

