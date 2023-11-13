package br.com.popularjavareposapp.network.okhttp.interceptor

import android.content.Context
import br.com.popularjavareposapp.R
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //TODD Save token with security
        val authToken = context.getString(R.string.auth_token)
        val gitHubApiVersionData = "2022-11-28"
        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION,  authToken)
            .addHeader(GITHUB_API_VERSION, "$gitHubApiVersionData")
            .build()
        return chain.proceed(request)
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val GITHUB_API_VERSION = "X-GitHub-Api-Version"
    }

}