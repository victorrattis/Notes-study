package com.vhra.study.notes.domain

data class AuthUserSession(
    val userId: String,
    val token: String
)