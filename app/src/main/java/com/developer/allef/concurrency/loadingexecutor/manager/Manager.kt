package com.developer.allef.concurrency.loadingexecutor.manager

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author allef.santos on 04/10/20
 */
object Manager {

    private const val CORE_POOL_SIZE = 2
    private const val MAX_POOL_SIZE = 10
    private const val KEEP_ALIVE_TIME = 50


    //Queue for all the Tasks
    private var WorkQueue: BlockingQueue<Runnable>? = null
    private var threadPoolExecutor: ThreadPoolExecutor? = null
    private  var managerInstance : Manager

    init {
        WorkQueue = LinkedBlockingQueue<Runnable>()
        threadPoolExecutor = ThreadPoolExecutor(
            CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(),
            TimeUnit.MILLISECONDS, WorkQueue
        )
        managerInstance = this
    }

    /*
    Make sure Manager is a SingleTon Hence private;
     */

    /*
    Make sure Manager is a SingleTon Hence private;
     */


    fun runTask(runnable: Runnable?) {
        threadPoolExecutor!!.execute(runnable)
    }

    fun getInstance(): Manager? {
        return managerInstance
    }



}