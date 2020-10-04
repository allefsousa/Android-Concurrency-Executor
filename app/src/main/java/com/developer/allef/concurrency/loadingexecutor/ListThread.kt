package com.developer.allef.concurrency.loadingexecutor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.allef.concurrency.R
import kotlinx.android.synthetic.main.activity_list_thread.*

class ListThread : AppCompatActivity() {

    private val listTaskNames = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_thread)
        Log.d("Allef", "onCreate: ${(0..100).random()}")
        initTasks()
        initRecyclerView()


    }

    private fun initTasks() {
        for (i in 0..5) {
            listTaskNames.add("Task Number $i")
        }
    }

    private fun initRecyclerView() {
        val listAdapter = ListThreadAdapter(listTaskNames)
        recycler.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@ListThread, LinearLayoutManager.VERTICAL, false)
            adapter = listAdapter
        }
    }
}