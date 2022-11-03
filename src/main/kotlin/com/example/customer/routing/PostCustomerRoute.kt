package com.example.customer.routing

import com.example.customer.model.CustomerDto
import com.example.customer.model.CustomerEntity
import com.example.customer.service.CustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.postCustomerRoute(service: CustomerService) {
    post {
        val customer = call.receive<CustomerDto>()
        service.add(customer)
        call.respond(HttpStatusCode.OK)
    }
}