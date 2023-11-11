package br.com.popularjavareposapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val login: String,
    @SerializedName("avatar_url")
    val photo: String
) : Parcelable