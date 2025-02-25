package com.example.sneakersshop.domain

import android.util.Log
import com.example.sneakersshop.data.UserAuth
import kotlinx.coroutines.runBlocking

class AuthController {

    private val userAuth = UserAuth()

    fun signIn(email: String, password: String): Boolean {
        var result = false
        if (isEmailValid(email)) {
            runBlocking {
                result = userAuth.signIn(email, password)
                Log.d("SignInController", "$result")
            }
            return result
        } else {
            return result
        }
    }
}