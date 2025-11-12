package com.corkcharge.corkcharge_an.data.repositoryImpl

import android.content.Context
import androidx.datastore.dataStore
import com.corkcharge.corkcharge_an.data.model.FcmToken
import com.corkcharge.corkcharge_an.data.repository.FcmRepository
import com.corkcharge.corkcharge_an.data.util.FcmTokenSerializer
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

val Context.fcmDataStore by dataStore(
    fileName = "fcm_tokens",
    serializer = FcmTokenSerializer
)

@Singleton
class FcmRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : FcmRepository {
    override suspend fun saveFcmToken(token: String) { // fcm 토큰 저장
        context.fcmDataStore.updateData { it.copy(fcmToken = token) }
    }

    override suspend fun getFcmToken(): String? { // fcm 토큰 불러오기
        val preferences = context.fcmDataStore.data.first()
        return preferences.fcmToken
    }

    override suspend fun clearToken() {
        context.fcmDataStore.updateData {
            FcmToken(null)
        }
    }
}