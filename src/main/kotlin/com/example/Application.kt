package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.config.*
import com.example.notification.core.BaseNotificationManager
import com.example.notification.core.BaseNotificationService
import com.example.notification.senders.email.EmailNotification
import com.example.notification.senders.email.EmailNotificationSender
import com.example.notification.senders.sms.SmsNotification
import com.example.notification.senders.sms.SmscSmsNotificationSender
import kotlinx.coroutines.runBlocking
import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.HtmlEmail
import java.net.URL

fun main() {
    val email = HtmlEmail()
    email.hostName = "smtp.yandex.ru"
    email.setSmtpPort(465)
    email.setAuthenticator(DefaultAuthenticator("dduzhinsky@ya.ru", ""))
    email.isSSLOnConnect = true
    email.setFrom("dduzhinsky@ya.ru")
    email.addTo("dduzhinsky@ya.ru")
    email.subject = "Test email with inline image sent using Kotlin"
    val kotlinLogoURL = URL("https://upload.wikimedia.org/wikipedia/commons/d/d4/Kotlin_logo.svg")
    val cid = email.embed(kotlinLogoURL, "Kotlin logo")
    email.setHtmlMsg("<html><h1>Kotlin logo</h1><img src=\"cid:$cid\"></html>")

    val notificationManager = BaseNotificationManager()
    val notificationService = BaseNotificationService(notificationManager)

    val emailSender = EmailNotificationSender()
    notificationService.register(emailSender)

    val smsSender = SmscSmsNotificationSender("duzhinsky", "")
    notificationService.register(smsSender)

    val notification = SmsNotification(
        "79539163347",
        "H2ello!",
        EmailNotification(
            email,
            null
        )
    )
    runBlocking { notificationService.sendNotification(notification) }

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
