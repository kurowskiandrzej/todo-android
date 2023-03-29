package com.kurowskiandrzej.core_ui.util

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "phone",
    device = "spec:width=360dp,height=640dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "phone_landscape",
    device = "spec:width=640dp,height=360dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "phone_foldable",
    device = "spec:width=673.5dp,height=841dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "tablet",
    device = "spec:width=1280dp,height=800dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "tablet_portrait",
    device = "spec:width=800dp,height=1280dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "phone_dark_mode",
    device = "spec:width=360dp,height=640dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone_landscape_dark_mode",
    device = "spec:width=640dp,height=360dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "phone_foldable_dark_mode",
    device = "spec:width=673.5dp,height=841dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "tablet_dark_mode",
    device = "spec:width=1280dp,height=800dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "tablet_portrait_dark_mode",
    device = "spec:width=800dp,height=1280dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class DevicePreviews
