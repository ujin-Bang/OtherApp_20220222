package com.example.otherapp_20220222.datas

import java.io.Serializable

class StoreData(
    val name: String,
    val rating: Double,
    val phonNum: String,
    val logoImageUrl : String,
): Serializable {
}