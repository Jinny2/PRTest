package com.example.data.repository

import android.content.Context
import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class KakaoDataSourceImpl @Inject constructor(
    private val context: Context
) : KakaoDataSource {
    override fun kakaoLogin(): Flow<OAuthToken> = callbackFlow {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {

            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->

                Log.i("debugKakao", "loginWithKakaoTalk 1 : $token /$error")
                token?.let {
                    trySendBlocking(it)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                Log.i("debugKakao", "loginWithKakaoTalk 2 : $token/ $error")

                token?.let {
                    trySendBlocking(it)
                }
            }
        }
        awaitClose()
    }

    override fun kakaoUserMe(): Flow<User> = callbackFlow {
        UserApiClient.instance.me { user, error ->
            Log.i("debugKakao", "kakaoUserMe : $user/ $error")
            user?.let {
                trySendBlocking(it)
            }
        }
        awaitClose()
    }

    override fun kakaoToken(): Flow<AccessTokenInfo> = callbackFlow {
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Log.e("TAG", "토큰 정보 보기 실패", error)
            } else if (tokenInfo != null) {
                trySendBlocking(tokenInfo)
                Log.i(
                    "TAG", "토큰 정보 보기 성공 \n회원번호: ${tokenInfo.id} \n만료시간: ${tokenInfo.expiresIn} 초"
                )
            }
        }
        awaitClose()
    }
}
