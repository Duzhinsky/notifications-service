package com.example.customer.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerDto(
    var id: Int,
    @JsonProperty("first_name")
    var firstName: String?,
    @JsonProperty("last_name")
    var lastName: String?,
    var email: String?
)

fun CustomerEntity.toDto(): CustomerDto {
    return CustomerDto(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}

fun CustomerDto.toEntity(): CustomerEntity {
    return CustomerEntity(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        lastModified = null
    )
}