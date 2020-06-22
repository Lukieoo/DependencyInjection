package com.lukieoo.dependencyinjection.retrofit.network

import com.lukieoo.dependencyinjection.retrofit.model.TopGames
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {

    @GET("/api/games")
    fun getTopGames(@Query("dates") dates:String,@Query("ordering") ordering:String):Flowable<TopGames>
}
