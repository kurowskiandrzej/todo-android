package com.kurowskiandrzej.core_ui.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kurowskiandrzej.core_ui.R

sealed interface UiText {

    data class Text(private val text: String) : UiText {

        override fun asString(context: Context): String {
            return text
        }

        @Composable
        override fun asString(): String {
            return text
        }
    }

    class ResourceId(
        @StringRes
        private val resourceId: Int,
        private vararg val args: Any
    ) : UiText {

        override fun asString(context: Context): String {
            return context.getString(resourceId, *args)
        }

        @Composable
        override fun asString(): String {
            return stringResource(id = resourceId, *args)
        }
    }

    fun asString(context: Context): String

    @Composable
    fun asString(): String

    companion object {

        val unknownError = ResourceId(R.string.unknown_error)

        fun orUnknownError(message: String?): UiText {
            return if (message != null) Text(message)
            else unknownError
        }
    }
}
