package com.example.sneakersshop

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class LoginUnitTest {
    private val validaor = Validator()

    @Test
    fun testValidEmail() {
        assertTrue(validaor.isValidEmail("test@example.com"))
        assertFalse(validaor.isValidEmail("invalid-email"))
    }

    @Test
    fun testValidPassword() {
        assertTrue(validaor.isValidPassword("Password123321"))
        assertFalse(validaor.isValidPassword("weak"))
    }
}