package com.example.bookresponcekotiln


data class BookModel(
    val abbrev: Abbrev,
    val author: String,
    val chapters: Int,
    val group: String,
    val name: String,
    val testament: String
)
{
    data class Abbrev(
        val en: String,
        val pt: String
    )
}




