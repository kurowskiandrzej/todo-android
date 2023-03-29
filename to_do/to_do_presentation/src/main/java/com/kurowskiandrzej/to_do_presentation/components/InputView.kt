package com.kurowskiandrzej.to_do_presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurowskiandrzej.core_ui.components.buttons.ActionIconButton
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing
import com.kurowskiandrzej.core_ui.util.UiText
import com.kurowskiandrzej.to_do_presentation.R

@Composable
fun InputView(
    modifier: Modifier = Modifier,
    input: String,
    onInput: (input: String) -> Unit,
    placeholderText: String,
    onSubmitClick: () -> Unit,
    enabled: Boolean,
    showProgressBar: Boolean
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .clip(MaterialTheme.shapes.small)
            .padding(MaterialTheme.spacing.spaceSmall)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = MaterialTheme.spacing.spaceSmall,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        if (showProgressBar) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(40.dp)
                    .weight(1f),
                color = MaterialTheme.colors.onSurface,
                strokeWidth = 4.dp
            )
        } else {
            TextField(
                modifier = Modifier
                    .weight(1f),
                value = input,
                onValueChange = onInput,
                placeholder = { Text(text = placeholderText) },
                shape = MaterialTheme.shapes.small,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    cursorColor = MaterialTheme.colors.onSurface,
                    focusedIndicatorColor =  MaterialTheme.colors.onSurface
                ),
                singleLine = true
            )
        }

        ActionIconButton(
            onClick = onSubmitClick,
            image = Icons.Filled.Add,
            color = MaterialTheme.colors.primary,
            contentDescription = UiText.ResourceId(R.string.submit_input).asString(),
            enabled = enabled
        )
    }
}

@Preview
@Composable
fun InputViewPreview() {
    ToDoAndroidTheme {
        Column(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.background)
                .padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputView(
                input = "Shopping list",
                onInput = {},
                placeholderText = "Preview placeholder",
                onSubmitClick = {},
                enabled = true,
                showProgressBar = false
            )
            InputView(
                input = "",
                onInput = {},
                placeholderText = "Preview placeholder",
                onSubmitClick = {},
                enabled = false,
                showProgressBar = false
            )
            InputView(
                input = "Shopping list",
                onInput = {},
                placeholderText = "Preview placeholder",
                onSubmitClick = {},
                enabled = false,
                showProgressBar = true
            )
        }
    }
}