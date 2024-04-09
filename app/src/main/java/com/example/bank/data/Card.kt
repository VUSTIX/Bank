package com.example.bank.data

import androidx.compose.ui.graphics.Brush

class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)