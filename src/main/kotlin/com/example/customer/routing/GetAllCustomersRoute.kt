package com.example.customer.routing

import com.example.customer.service.CustomerService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllCustomersRoute(service: CustomerService) {
    get() {
        call.respond(service.findAll())
    }
}