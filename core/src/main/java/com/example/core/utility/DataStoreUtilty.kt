package com.example.core.utility

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


enum class UiMode {
    LIGHT, DARK
}

class DataStoreUtilty (private val dataStore: DataStore<Preferences>) {
    companion object {
        val USER_DARK_TEXT_MODE_KEY = stringPreferencesKey("DARK_TEXT_MODE")
        val USER_DARK_MODE_KEY = booleanPreferencesKey("DARK_MODE")
    }

    suspend fun setUiMode(uiMode: UiMode) {
        dataStore.edit { preferences ->
            Log.i("debugKakao", "setUiMode: ${preferences[USER_DARK_MODE_KEY]}")
            preferences[USER_DARK_MODE_KEY] = when (uiMode) {
                UiMode.LIGHT -> false
                UiMode.DARK -> true
            }
        }
    }

    val uiModeFlow: Flow<UiMode> = dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preference ->
            val isDarkMode = preference[USER_DARK_MODE_KEY] ?: false
            Log.i("debugKakao", "uiModeFlow: $isDarkMode")
            when (isDarkMode) {
                true -> UiMode.DARK
                false -> UiMode.LIGHT
            }
        }

    suspend fun saveStringData(value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[USER_DARK_TEXT_MODE_KEY] = value
        }
    }

    fun readStringFlow(default: String = ""): Flow<String> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[USER_DARK_TEXT_MODE_KEY] ?: default
            }

    fun saveSyncStringData(value: String) = runBlocking { saveStringData(value) }

}
