package com.example.presentation

import android.content.Context
import android.util.Log
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class KakaoProvider(private val context: Context) {

    fun kakaoLogin(): Flow<User> = callbackFlow {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {

            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->

                Log.i("debugKakao", "loginWithKakaoTalk 1 : $token /$error")
                token?.let {
//                    trySendBlocking(it)
                    UserApiClient.instance.me { user, error ->
                        Log.i("debugKakao", "kakaoUserMe 1: $user/ $error")
                        user?.let {
                            trySendBlocking(it)
                        }
                    }
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                Log.i("debugKakao", "loginWithKakaoTalk 2 : $token/ $error")

                token?.let {
                    UserApiClient.instance.me { user, error ->
                        Log.i("debugKakao", "kakaoUserMe 2: $user/ $error")
                        user?.let {
                            trySendBlocking(it)
                        }
                    }
                }
            }
        }
        awaitClose()
    }

    fun kakaoUserMe(): Flow<User> = callbackFlow {
        UserApiClient.instance.me { user, error ->
            Log.i("debugKakao", "kakaoUserMe : $user/ $error")
            user?.let {
                trySendBlocking(it)
            }
        }
        awaitClose()
    }
}