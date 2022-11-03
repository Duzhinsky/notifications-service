package com.example.commons.email

class EmailServiceImpl : EmailService {
    override suspend fun sendEmail(address: String, message: String) {
        println("Send email to $address with message: $message")
    }
}