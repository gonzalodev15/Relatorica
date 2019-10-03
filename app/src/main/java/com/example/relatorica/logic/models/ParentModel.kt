package com.example.relatorica.logic.models

object ParentModel {

    data class Response(
        val data: ArrayList<Parent>,
        val error: Boolean,
        val message: String
    )

    data class Parent(
        val parentId: Int,
        val names: String,
        val lastNames: String,
        val credentials: String,
        val email: String,
        val cellphone: String,
        val birthDate: String,
        val registerDate: String,
        val status: String
    )
}