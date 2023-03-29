package com.kurowskiandrzej.core_ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme

@Composable
fun ActionIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    image: ImageVector,
    color: Color,
    contentDescription: String,
    enabled: Boolean = true
) {
    Button(
        modifier = Modifier
            .width(50.dp)
            .heightIn(50.dp)
            .then(modifier),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Icon(
            imageVector = image,
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
fun ActionIconButtonPreview() {
    ToDoAndroidTheme {
        Column(
            modifier = Modifier
                .width(100.dp)
                .height(240.dp)
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionIconButton(
                onClick = {},
                image = Icons.Filled.Done,
                color = MaterialTheme.colors.primary,
                contentDescription = "Icon for preview"
            )
            ActionIconButton(
                onClick = {},
                image = Icons.Filled.Close,
                color = MaterialTheme.colors.error,
                contentDescription = "Icon for preview"
            )
            ActionIconButton(
                onClick = {},
                image = Icons.Filled.Close,
                color = MaterialTheme.colors.error,
                contentDescription = "Icon for preview",
                enabled = false
            )
        }
    }
}