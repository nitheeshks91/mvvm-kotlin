package com.sample.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class ModelBase : Parcelable{
    @SerializedName("code")
    var errorCode : String= ""

    @SerializedName("desc")
    var errorMessage:String = ""
    
}