package com.developer.allef.concurrency

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startWorking()

    }
}

class MyRunnable : Runnable {
    override fun run() {
        Log.d("Generic", "Running From Thread " +
                Thread.currentThread().id)
        // Your Long Running Computation Task
    }
}

fun startWorking() {
    val executor: Executor = Executors.newFixedThreadPool(2)
    for (i in 0..19) {
        executor.execute(MyRunnable())
    }
}

