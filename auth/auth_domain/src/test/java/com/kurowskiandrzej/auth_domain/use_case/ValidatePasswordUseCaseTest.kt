package com.kurowskiandrzej.auth_domain.use_case

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ValidatePasswordUseCaseTest {

    private lateinit var validatePasswordUseCase: ValidatePasswordUseCase

    @Before
    fun setUp() {
        validatePasswordUseCase = ValidatePasswordUseCase()
    }

    @Test
    fun `Valid passwords return success`() {
        val result = validatePasswordUseCase(password = "P\$Atw0rd2")

        assertThat(result).isInstanceOf(ValidatePasswordResult.Success::class.java)
    }

    @Test
    fun `Password with white spaces return proper failure`() {
        val result = validatePasswordUseCase(password = "This@33 password")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                containsWhiteSpaces = true
            )
        )
    }

    @Test
    fun `Password without special character return proper failure`() {
        val result = validatePasswordUseCase(password = "pASSw0rd")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                noSpecialCharacter = true
            )
        )
    }

    @Test
    fun `Password without digit return proper failure`() {
        val result = validatePasswordUseCase(password = "pASS$%word")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                noDigit = true
            )
        )
    }

    @Test
    fun `Password without lowercase letter return proper failure`() {
        val result = validatePasswordUseCase(password = "PASS$99OO_JH")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                noLowerCaseLetter = true
            )
        )
    }

    @Test
    fun `Password without uppercase letter return proper failure`() {
        val result = validatePasswordUseCase(password = "pass$%word45")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                noUpperCaseLetter = true
            )
        )
    }

    @Test
    fun `Too long password return proper failure`() {
        var password = "pASS$%w12ord"

        repeat(times = 100) {
            password += "x"
        }

        val result = validatePasswordUseCase(password = password)

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                isTooLong = true
            )
        )
    }

    @Test
    fun `Too short password return proper failure`() {
        val result = validatePasswordUseCase(password = "pS$%w5")

        assertThat(result).isEqualTo(
            ValidatePasswordResult.Failure(
                isTooShort = true
            )
        )
    }
}