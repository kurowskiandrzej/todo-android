package com.kurowskiandrzej.core_ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurowskiandrzej.core_ui.ui.theme.spacing
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.button,
    enabled: Boolean = true,
    showProgressBar: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .defaultMinSize(minWidth = 100.dp, minHeight = 50.dp)
            .then(modifier),
        enabled = enabled,
        shape = MaterialTheme.shapes.small
    ) {
        if (showProgressBar) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = MaterialTheme.colors.onPrimary,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                style = textStyle,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.padding(MaterialTheme.spacing.spaceSmall)
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ActionButtonPreview() {
    ToDoAndroidTheme {
        Column(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionButton(text = "Preview", onClick = {})
            ActionButton(text = "Preview", onClick = {}, enabled = false)
        }
    }
}