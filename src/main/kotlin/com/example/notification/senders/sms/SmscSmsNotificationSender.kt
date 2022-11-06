package com.example.notification.senders.sms

import com.example.notification.core.NotificationSender
import com.example.notification.core.model.ManagedNotification
import com.example.notification.core.model.Notification
import com.example.notification.core.model.NotificationStatus
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class SmscSmsNotificationSender(val login: String, val password: String) : NotificationSender {

    override suspend fun sendNotification(managedNotification: ManagedNotification) {
        val notification = managedNotification.notification
        if (notification !is SmsNotification) throw IllegalArgumentException()

        runBlocking {
            managedNotification.status = NotificationStatus.SENT

            val client = HttpClient(CIO)

            val response: HttpResponse = client.get("https://smsc.ru/sys/send.php") {
                url {
                    parameter("phones", notification.phoneNumber)
                    parameter("mes", notification.message)
                    parameter("login", login)
                    parameter("psw", this@SmscSmsNotificationSender.password)
                    parameter("fmt", 0)
                    println(it.buildString())
                }
            }
            client.close()
            val responseText = response.bodyAsText()
            println(responseText)
            if (!responseText.contains("OK")) {
                managedNotification.status = NotificationStatus.FAILED
                managedNotification.status.message = responseText
            } else {
                managedNotification.status = NotificationStatus.DELIVERED
            }
        }

    }

    override fun isNotificationAcceptable(notification: Notification): Boolean {
        return notification is SmsNotification
    }
}