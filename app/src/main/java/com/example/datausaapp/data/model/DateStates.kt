package com.example.datausaapp.data.model

import com.google.gson.annotations.SerializedName
// Chamando o data da Api
data class DateStates(
    @SerializedName("data")
    val `data`: List<State>
)