package com.vhra.study.notes.data.local

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.vhra.study.notes.domain.AuthUserLocalDataSource
import com.vhra.study.notes.domain.AuthUserSession


class SharedPreferenceUserDataSource constructor(
    private val context: Context
) : AuthUserLocalDataSource {
    override fun save(authUserSession: AuthUserSession) {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val sharedPreference = EncryptedSharedPreferences.create(
            "user-session",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPreference.edit {
            putString("userId", authUserSession.userId)
            putString("userToken", authUserSession.token)
            apply()
        }
    }

    override fun hasUserSession(callback: (Boolean) -> Unit) {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val sharedPreference = EncryptedSharedPreferences.create(
            "user-session",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        val token = sharedPreference.getString("userToken", null)
        callback(token != null)
    }
}