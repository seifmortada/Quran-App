package com.example.domain.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class MoshafModel(
    val id: Int,
    val moshafType: Int,
    val name: String,
    val server: String,
    val surahList: String,
    val surahTotal: Int
): Parcelable
