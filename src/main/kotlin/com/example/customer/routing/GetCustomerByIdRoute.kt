package com.example.customer.routing

import com.example.customer.service.CustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getCustomerByIdRoute(service: CustomerService) {
    get("/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val customer =
            service.findById(id) ?: return@get call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
        call.respond(customer)
    }
}