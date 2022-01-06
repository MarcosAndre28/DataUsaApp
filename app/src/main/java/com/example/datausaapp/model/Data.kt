package com.example.datausaapp.repository.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(@SerializedName("data") var state: List<State>)
data class State(
    @SerializedName("State") var state: String = "",
    @SerializedName("Population") var population: Int = 0
)



