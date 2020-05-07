package com.example.questionsix

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import com.google.gson.Gson
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class EmailService : Service(){

    val TAG = "EmailService"
    private var myMessenger = Messenger(ExampleHandler())
    private lateinit var executorService: ExecutorService

    override fun onBind(intent: Intent): IBinder? {
        Log.i(TAG, "Service onBind, appName: ${intent.extras?.getString("clientName")}")
        return myMessenger.binder
    }

    override fun onCreate() {
        executorService = Executors.newSingleThreadExecutor()
        Log.i(TAG, "Service onCreate")
        super.onCreate()
    }

    private fun sendBroadcast(response: String) {
        val intent = Intent()
        val extras = Bundle()
        extras.putString("result", response)
        intent.putExtras(extras)
        sendBroadcast(intent)
    }

    internal inner class ExampleHandler : Handler() {
        override fun handleMessage(msg: Message) {

            val data = msg.data
            val dataString = data.getString("email")
            val hearNode = Gson().fromJson(dataString, Node::class.java)
            executorService.submit(ExampleRunnable(hearNode))
        }
    }

    internal inner class ExampleRunnable(private val email: Node) : Runnable {

        override fun run() {
            deleteDuplicates(email)
            val responseJson = Gson().toJson(email)
            sendBroadcast(responseJson)
        }
    }

    fun deleteDuplicates(head: Node?) {

        val hashSet = hashSetOf<String>()
        var current = head
        var node: Node? = null

        while (current != null) {
            val value = current.value

            if (hashSet.contains(value)) {
                node!!.next = current.next
            } else {
                hashSet.add(value)
                node = current
            }
            current = current.next
        }

    }

    data class Node(val value: String) {
        var next: Node? = null
    }

}

