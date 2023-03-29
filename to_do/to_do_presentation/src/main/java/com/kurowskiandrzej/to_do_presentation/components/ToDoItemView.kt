package com.kurowskiandrzej.to_do_presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing


@Composable
fun ToDoItemView(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colors.surface)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Preview
@Composable
fun ToDoItemViewPreview() {
    ToDoAndroidTheme {
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            ToDoItemView {
                Text(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceSmall)
                        .weight(1f),
                    text = "First list"
                )
                Text(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceSmall),
                    text = "0/30"
                )
            }

            ToDoItemView {
                Text(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.spaceSmall)
                        .weight(1f),
                    text = "First task"
                )
            }
        }
    }
}