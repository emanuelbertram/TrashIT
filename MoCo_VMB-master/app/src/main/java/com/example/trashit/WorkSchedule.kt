package com.example.trashit

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.*
import java.util.concurrent.TimeUnit



class RemindWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        sendNotification()

        return Result.success()
    }
}


class Reminder(private val context : Context) {
    @RequiresApi(Build.VERSION_CODES.M)
    val constraints = Constraints.Builder()
        .setRequiresBatteryNotLow(true)
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresCharging(true)
        .setRequiresStorageNotLow(true)
        .setRequiresDeviceIdle(true)
        .build()


    fun sendNotification(){
        val RemindWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RemindWorker>().setInitialDelay(1, TimeUnit.DAYS).build()

        WorkManager
            .getInstance(context)
            .enqueue(RemindWorkRequest)
    }
}


fun sendNotification(){

}