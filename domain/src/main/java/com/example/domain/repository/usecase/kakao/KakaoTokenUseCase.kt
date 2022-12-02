package com.example.domain.repository.usecase.kakao

import com.example.domain.repository.KakaoRepository
import com.kakao.sdk.user.model.AccessTokenInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoTokenUseCase @Inject constructor(private val kakaoRepository: KakaoRepository) {
    operator fun invoke(): Flow<AccessTokenInfo> = kakaoRepository.tokenKakaoTalk()
}