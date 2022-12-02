package com.example.data.repository

import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.flow.Flow

interface KakaoDataSource {
    fun kakaoLogin(): Flow<OAuthToken>
    fun kakaoUserMe(): Flow<User>
    fun kakaoToken(): Flow<AccessTokenInfo>
}