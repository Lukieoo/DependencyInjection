package com.lukieoo.dependencyinjection.retrofit.model

import com.lukieoo.dependencyinjection.retrofit.model.Result

data class TopGames(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>,
    val user_platforms: Boolean
)