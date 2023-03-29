package com.kurowskiandrzej.auth_domain.use_case

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ValidateEmailUseCaseTest {

    private lateinit var validateEmailUseCase: ValidateEmailUseCase

    @Before
    fun setUp() {
        validateEmailUseCase = ValidateEmailUseCase()
    }

    @Test
    fun `Valid email returns true`() {
        val result = validateEmailUseCase("email@test.com")

        assertThat(result).isTrue()
    }

    @Test
    fun `Email without @ sign returns false`() {
        val result = validateEmailUseCase("email_test.com")

        assertThat(result).isFalse()
    }

    @Test
    fun `Email without dot returns false`() {
        val result = validateEmailUseCase("email@testcom")

        assertThat(result).isFalse()
    }

    @Test
    fun `Email without extension returns false`() {
        val result = validateEmailUseCase("email@test.")

        assertThat(result).isFalse()
    }
}