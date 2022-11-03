package com.example.customer.routing

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

data class ChangeEmailDto(val email: String)

fun Route.patchChangeCustomerEmail() {
    patch("/{id}") {
        val requestDto = call.receive<ChangeEmailDto>()

    }
}