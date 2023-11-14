package br.com.popularjavareposapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryResponse(
    val items: List<RepositoryModel>
) : Parcelable

fun RepositoryResponse.toRepositories(): List<RepositoryModel> {
    val repositories = ArrayList<RepositoryModel>()
    repositories.addAll(items)
    return repositories
}