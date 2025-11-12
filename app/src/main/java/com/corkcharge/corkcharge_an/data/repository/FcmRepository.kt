package com.corkcharge.corkcharge_an.data.repository

interface FcmRepository {
    suspend fun saveFcmToken(token: String)
    suspend fun getFcmToken(): String?

    suspend fun clearToken()
}