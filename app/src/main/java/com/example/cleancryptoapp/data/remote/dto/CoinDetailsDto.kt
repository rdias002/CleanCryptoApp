package com.example.cleancryptoapp.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.example.cleancryptoapp.domain.model.CoinDetails
import com.example.cleancryptoapp.domain.model.TeamMember
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinDetailsDto(

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("is_active")
    val isActive: Boolean? = null,

    @field:SerializedName("is_new")
    val isNew: Boolean? = null,

    @field:SerializedName("proof_type")
    val proofType: String? = null,

    @field:SerializedName("first_data_at")
    val firstDataAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("team")
    val team: List<TeamMemberDto>? = null,

    @field:SerializedName("links_extended")
    val linksExtended: List<LinksExtendedItemDto>? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("tags")
    val tags: List<TagsItemDto>? = null,

    @field:SerializedName("last_data_at")
    val lastDataAt: String? = null,

    @field:SerializedName("whitepaper")
    val whitepaper: WhitepaperDto? = null,

    @field:SerializedName("org_structure")
    val orgStructure: String? = null,

    @field:SerializedName("hardware_wallet")
    val hardwareWallet: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("development_status")
    val developmentStatus: String? = null,

    @field:SerializedName("hash_algorithm")
    val hashAlgorithm: String? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("started_at")
    val startedAt: String? = null,

    @field:SerializedName("links")
    val links: LinksDto? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("open_source")
    val openSource: Boolean? = null
) : Parcelable {

    fun toCoinDetails(): CoinDetails = CoinDetails(
        id = id ?: "",
        name = name ?: "",
        description = description ?: "",
        symbol = symbol ?: "",
        rank = rank ?: -1,
        isActive = isActive ?: false,
        tags = tags?.map { it.name ?: "" } ?: listOf(),
        team = team?.map { it.toTeamMember() } ?: listOf()
    )
}

@Parcelize
data class LinksDto(

    @field:SerializedName("youtube")
    val youtube: List<String>? = null,

    @field:SerializedName("website")
    val website: List<String>? = null,

    @field:SerializedName("facebook")
    val facebook: List<String>? = null,

    @field:SerializedName("explorer")
    val explorer: List<String>? = null,

    @field:SerializedName("reddit")
    val reddit: List<String>? = null,

    @field:SerializedName("source_code")
    val sourceCode: List<String>? = null
) : Parcelable

@Parcelize
data class StatsDto(

    @field:SerializedName("followers")
    val followers: Int? = null,

    @field:SerializedName("contributors")
    val contributors: Int? = null,

    @field:SerializedName("stars")
    val stars: Int? = null,

    @field:SerializedName("subscribers")
    val subscribers: Int? = null
) : Parcelable

@Parcelize
data class WhitepaperDto(

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("link")
    val link: String? = null
) : Parcelable

@Parcelize
data class TeamMemberDto(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("position")
    val position: String? = null
) : Parcelable{
	fun toTeamMember(): TeamMember = TeamMember(
		id?:"",
		name?:"",
		position?:"",
	)
}

@Parcelize
data class LinksExtendedItemDto(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("stats")
    val stats: StatsDto? = null
) : Parcelable

@Parcelize
data class TagsItemDto(

    @field:SerializedName("coin_counter")
    val coinCounter: Int? = null,

    @field:SerializedName("ico_counter")
    val icoCounter: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null
) : Parcelable
