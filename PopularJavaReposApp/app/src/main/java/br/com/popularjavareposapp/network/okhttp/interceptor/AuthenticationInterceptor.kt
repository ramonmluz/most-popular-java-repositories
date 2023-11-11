package br.com.popularjavareposapp.network.okhttp.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //TODD Save token with security
        val authToken =
            "Bearer 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"
        val gitHubApiVersionData = "2022-11-28"
        val request = chain.request().newBuilder()
            .addHeader(Companion.AUTHORIZATION, "Bearer $authToken")
            .addHeader(GITHUB_API_VERSION, "Bearer $gitHubApiVersionData")
            .build()
        return chain.proceed(request)
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val GITHUB_API_VERSION = "X-GitHub-Api-Version"
    }

}