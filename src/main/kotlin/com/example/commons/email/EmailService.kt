package com.example.commons.email

interface EmailService {
    suspend fun sendEmail(address: String, message: String)
}