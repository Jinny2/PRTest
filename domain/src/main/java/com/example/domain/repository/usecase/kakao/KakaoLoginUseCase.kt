package com.example.domain.repository.usecase.kakao

import com.example.domain.repository.KakaoRepository
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(private val kakaoRepository: KakaoRepository) {
    operator fun invoke(): Flow<Pair<OAuthToken, User>> = kakaoRepository.loginKakaoTalk()
}