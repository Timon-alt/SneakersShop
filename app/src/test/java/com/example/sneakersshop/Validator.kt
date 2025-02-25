package com.example.sneakersshop

class Validator {
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Коммент из ветки sprint-1
    // Aboba

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}