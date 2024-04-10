package com.works.networklibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.works.networkmodule.RetrofitClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient.printBaseUrl()

    }
}