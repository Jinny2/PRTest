package com.example.presentation.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.core.utility.DataStoreUtilty
import com.example.core.utility.UiMode
import com.example.presentation.R
import com.example.presentation.databinding.ActivitySecondBinding
import kotlinx.coroutines.launch

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "PRTest")

class SecondActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySecondBinding
    private lateinit var dataStoreUtilty: DataStoreUtilty
    private var isDarkMode = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        dataStoreUtilty = DataStoreUtilty(dataStore)
        observeUiPreferences()
        setUpEvent()
    }
    private fun observeUiPreferences() {
        dataStoreUtilty.uiModeFlow.asLiveData().observe(this) { uiMode ->
            Log.i("debugKakao", "observeUiPreferences: $uiMode")
            when (uiMode) {
                UiMode.LIGHT -> onLightMode()
                UiMode.DARK -> onDarkMode()
            }
        }

        dataStoreUtilty.readStringFlow(mBinding.modeText.text.toString()).asLiveData().observe(this) { text->
            Log.i("debugKakao", "readStringFlow: $text")
            mBinding.modeText.text = text
        }

    }
    private fun setUpEvent() {
        mBinding.modeBtn.setOnClickListener {
            lifecycleScope.launch {
                Log.i("debugKakao", "setUpEvent: $isDarkMode")
                when (isDarkMode) {
                    true ->{
                        dataStoreUtilty.setUiMode(UiMode.LIGHT)
                        dataStoreUtilty.saveSyncStringData("낮")
                    }
                    false -> {
                        dataStoreUtilty.setUiMode(UiMode.DARK)
                        dataStoreUtilty.saveSyncStringData("밤")
                    }
                }
            }
        }
    }

    private fun onLightMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        isDarkMode = false
    }
    private fun onDarkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        isDarkMode = true
    }
}