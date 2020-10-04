package com.developer.allef.concurrency.loadingexecutor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developer.allef.concurrency.R
import com.developer.allef.concurrency.loadingexecutor.manager.Manager
import com.developer.allef.concurrency.loadingexecutor.manager.Task
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * @author allef.santos on 03/10/20
 */
class ListThreadAdapter(private val listTaskNames: MutableList<String>) : RecyclerView.Adapter<ListThreadAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listTaskNames[position]

        holder.bind(item, position,context)

    }

    override fun getItemCount() = listTaskNames.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String, position: Int, context: Context) {
            itemView.parent_layout.setOnClickListener {
                runTask("Task No" + position, itemView.status, itemView.progressBar,context)
            }
            itemView.task_name.text = item
        }

        private fun runTask(
            taskName: String,
            status: TextView,
            progressBar: ProgressBar,
            context: Context
        ) {
            val task = Task(context, taskName, progressBar, status)

            Manager.getInstance()?.runTask(task)

        }

    }
}