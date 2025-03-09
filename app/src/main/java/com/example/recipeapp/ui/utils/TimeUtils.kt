package com.example.recipeapp.ui.utils

fun splitTotalMinutesIntoHoursAndMinutes(totalMinutes: Int): Pair<Int, Int> {
    val hours = totalMinutes / 60
    val remainingMinutes = totalMinutes % 60
    return hours to remainingMinutes
}