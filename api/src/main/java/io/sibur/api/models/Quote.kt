package io.sibur.api.models

import com.google.gson.annotations.SerializedName

data class Quote(
    val quote: String,
    val author: String,
    @SerializedName("cat")
    val category: String
)