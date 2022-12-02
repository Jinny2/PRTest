package com.example.presentation.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.usecase.kakao.KakaoLoginUseCase
import com.example.domain.repository.usecase.kakao.KakaoTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val kakaotokenUseCase: KakaoTokenUseCase
) : ViewModel() {

    fun kakaoLogin(callback: () -> Unit) = viewModelScope.launch {
        kakaoLoginUseCase.invoke().collect {
            Log.i("debugKakao", "MainViewModel kakaoLogin : $it")
            callback()
        }
    }

    fun kakaoToken(callback: () -> Unit) = viewModelScope.launch {
        kakaotokenUseCase.invoke().collect { info ->
            Log.i("debugKakao", "MainViewModel kakaoToken : $info")
            callback()
        }
    }
}
