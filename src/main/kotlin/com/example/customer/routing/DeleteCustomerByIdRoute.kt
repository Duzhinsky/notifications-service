package com.example.customer.routing

import com.example.customer.service.CustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deleteCustomerByIdRoute(service: CustomerService) {
    delete("/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        when(val deleteCount = service.deleteById(id)) {
            0L -> call.respond(HttpStatusCode.NotFound)
            else -> call.respond(HttpStatusCode.OK, "$deleteCount customer(s) was deleted")
        }
    }
}