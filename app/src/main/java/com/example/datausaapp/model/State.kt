package com.example.datausaapp.model

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("State") val name: String= "",
    @SerializedName("Population") val pupulation: Int = 0
)
