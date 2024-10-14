package com.example.projet_android.model

data class Player(val id: String, val name: String, val inventory: Inventory, val isBan: Boolean = false) {}