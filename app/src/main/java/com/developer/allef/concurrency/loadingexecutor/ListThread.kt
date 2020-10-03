package com.developer.allef.concurrency.loadingexecutor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.developer.allef.concurrency.R

class ListThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_thread)

        Log.d("Allef", "onCreate: ${(0..100).random()}")


    }
}