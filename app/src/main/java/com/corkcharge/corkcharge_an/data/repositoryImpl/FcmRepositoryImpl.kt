package com.corkcharge.corkcharge_an.data.repositoryImpl

import android.content.Context
import androidx.datastore.dataStore
import com.corkcharge.corkcharge_an.data.repository.FcmRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

val Context.fcmDataStore by dataStore(
    fileName = "fcm_tokens",
    serializer = FcmTokenSerializer
)

@Singleton
class FcmRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : FcmRepository {
}