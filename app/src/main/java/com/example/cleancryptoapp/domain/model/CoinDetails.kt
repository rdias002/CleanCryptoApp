package com.example.cleancryptoapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinDetails(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
) : Parcelable


@Parcelize
data class TeamMember(
    val id: String,
    val name: String,
    val position: String
) : Parcelable

