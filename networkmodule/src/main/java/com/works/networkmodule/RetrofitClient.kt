package com.works.networkmodule


import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitCustomerClient {

    private val Base_URL = "http://customer.mecomkou.com"
    private var retrofit: Retrofit? = null

    // Bu değişkeni tokeninizi saklamak için kullanabilirsiniz.
    private var authToken: String? = null

    val client = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            var newRequest = originalRequest
            authToken?.let { token ->
                newRequest = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
            }
            chain.proceed(newRequest)
        }
        .build()

    fun setAuthToken(token: String) {
        authToken = token
    }

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit
                .Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit as Retrofit
    }

    fun printBaseUrl()
    {
        Log.e("Lütfen", this.getClient().baseUrl().toString())
    }
}