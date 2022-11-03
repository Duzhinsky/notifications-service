package com.example.config

import com.example.customer.routing.customerRoutes
import io.ktor.server.application.*

fun Application.configureRouting() {
    customerRoutes()
}