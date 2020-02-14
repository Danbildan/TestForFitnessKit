package com.example.testforfitnesskit.model

enum class WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    fun day() = this.ordinal +1
}