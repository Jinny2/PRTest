package com.example.data

import android.util.Log
import com.example.data.repository.KakaoDataSource
import com.example.domain.repository.KakaoRepository
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KakaoRepositoryImpl @Inject constructor(
    private val kakaoDataSource: KakaoDataSource
) : KakaoRepository {

    override fun loginKakaoTalk(): Flow<Pair<OAuthToken, User>> {
        return flow {
            kakaoDataSource.kakaoLogin().collect { token ->
                Log.i("debugKakao", "kakaoLogin token : $token")
                kakaoDataSource.kakaoUserMe().collect { user ->
                    Log.i("debugKakao", "kakaoUserMe : $user")
                    emit(Pair(token, user))
                }
            }
        }
    }

    override fun tokenKakaoTalk(): Flow<AccessTokenInfo> {
        return flow {
            kakaoDataSource.kakaoToken().collect { info ->
                Log.i("debugKakao", "kakaoToken info : $info")
            }
        }
    }
}
