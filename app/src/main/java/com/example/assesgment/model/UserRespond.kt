package com.example.assesgment.model

data class UserRespond(
    var name: String,
    var products:List<User>,
    var total: Int,
    var skip:Int,
    var limit:Int,

    )
