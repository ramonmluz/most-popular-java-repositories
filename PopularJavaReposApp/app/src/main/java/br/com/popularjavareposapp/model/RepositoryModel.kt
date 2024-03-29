package br.com.popularjavareposapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryModel(
    val id: Int,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val description: String,
    @SerializedName("stargazers_count")
    val stargazers: Int,
    @SerializedName("forks_count")
    val forks: Int,
    @SerializedName("owner")
    val user: User,
) : Parcelable