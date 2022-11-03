package com.example.customer.model

import java.time.LocalDateTime

data class CustomerEntity(
    var id: Int,
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var lastModified: LocalDateTime?
)