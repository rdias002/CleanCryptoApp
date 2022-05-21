package com.example.cleancryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.example.cleancryptoapp.domain.model.Coin

data class CoinDto(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("symbol")
	val symbol: String? = null,

	@field:SerializedName("is_new")
	val isNew: Boolean? = null,

	@field:SerializedName("type")
	val type: String? = null
){
	fun toCoin(): Coin = Coin(
		id?:"",
		isActive?:false,
		name?:"",
		rank?:-1,
		symbol?:"",
	)
}
