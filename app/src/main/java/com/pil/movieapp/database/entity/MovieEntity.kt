package com.pil.movieapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
class MovieEntity(
    @PrimaryKey var id: Int,
    var originalLanguage: String,
    var originalTitle: String,
    var overview: String,
    var popularity: Float,
    var posterPath: String,
    var releaseDate: String,
    var title: String,
    var voteAverage: Float,
    var voteCount: Int,
)