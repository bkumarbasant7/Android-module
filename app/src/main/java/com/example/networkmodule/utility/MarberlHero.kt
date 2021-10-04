package com.example.networkmodule.utility

class MarberlHero : ArrayList<MarberlHeroItem>()

data class MarberlHeroItem(
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
)