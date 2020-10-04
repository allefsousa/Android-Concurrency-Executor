package com.developer.allef.concurrency.loadingexecutor.manager

import android.app.Activity
import android.content.Context
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*


/**
 * @author allef.santos on 04/10/20
 */
class Task(
    val mContext: Context,
    val taskName: String,
    val progressBar: ProgressBar,
    val statusTextView: TextView
) : Runnable {
    override fun run() {
        val step: Int = generateRandomStep()

        try {
            var i = 0
            while (i < 100) {
                i += step
                val finalI = i


                /*
                To update the progressBar and status TextView, we need to create a new Runnable runs
                on the UI thread as currently this task is running in a background thread.
                */(mContext as Activity).runOnUiThread {
                    statusTextView.text = "$finalI%"
                    progressBar.progress = finalI
                }
                Thread.sleep(500)
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private fun generateRandomStep(): Int {
        val multiple = intArrayOf(2, 5, 10, 20, 25, 50)
        val random: Int = Random().nextInt(5)
        return multiple[random]
    }
}