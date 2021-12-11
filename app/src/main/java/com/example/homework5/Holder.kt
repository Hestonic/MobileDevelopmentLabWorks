package com.example.homework5

object Holder {

    private val models = listOf(
        Item(info = "1"),
        Item(info = "2"),
        Item(info = "3")
    )

}

data class Item(val info: String)