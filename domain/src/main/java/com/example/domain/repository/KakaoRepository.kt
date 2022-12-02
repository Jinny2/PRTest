package com.example.domain.repository

import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.flow.Flow

interface KakaoRepository {
    fun loginKakaoTalk(): Flow<Pair<OAuthToken, User>>
    fun tokenKakaoTalk(): Flow<AccessTokenInfo>
}