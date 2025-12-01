package com.corkcharge.myapplication.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform