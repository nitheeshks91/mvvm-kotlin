package com.sample.app.domain.model

import com.google.gson.annotations.SerializedName


data class User(@SerializedName("userId")val _username:String ,
                @SerializedName("title")val _password:String)