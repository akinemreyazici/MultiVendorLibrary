package com.works.networklibrary

import android.util.Log
import com.works.RetrofitClient

class CustomerNetwork {

    val client = RetrofitClient.getClient()

    fun showClient()
    {
        Log.e("SelamClient",client.baseUrl().toString())
    }
}