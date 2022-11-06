package com.example.customer.routing

import com.example.customer.repository.CustomerRepository
import com.example.customer.repository.CustomerRepositoryImpl
import com.example.customer.service.CustomerService
import com.example.customer.service.CustomerServiceImpl
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.customerRoutes() {

    val repo: CustomerRepository = CustomerRepositoryImpl()
    val service: CustomerService = CustomerServiceImpl(repo)
//
//    val notificationManager = NotificationManagerImpl()
//    val emailSender = EmailNotificationSender(EmailServiceImpl())
//    notificationManager.registerNotificationSender(emailSender)

    routing {
        route("/customer") {
            getAllCustomersRoute(service)
            getCustomerByIdRoute(service)
            postCustomerRoute(service)
            deleteCustomerByIdRoute(service)
        }
    }
}