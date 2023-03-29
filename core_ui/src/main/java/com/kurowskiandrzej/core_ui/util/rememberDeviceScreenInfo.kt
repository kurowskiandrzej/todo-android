package com.kurowskiandrzej.core_ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberDeviceScreenInfo(): DeviceScreenInfo {
    val configuration = LocalConfiguration.current

    return DeviceScreenInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> DeviceScreenType.Compact
            configuration.screenWidthDp < 840 -> DeviceScreenType.Medium
            else -> DeviceScreenType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenHeightDp < 480 -> DeviceScreenType.Compact
            configuration.screenHeightDp < 900 -> DeviceScreenType.Medium
            else -> DeviceScreenType.Expanded
        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}

data class DeviceScreenInfo(
    val screenWidthInfo: DeviceScreenType,
    val screenHeightInfo: DeviceScreenType,
    val screenWidth: Dp,
    val screenHeight: Dp
)