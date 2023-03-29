package com.kurowskiandrzej.core_ui.util

sealed interface DeviceScreenType {
    object Compact: DeviceScreenType
    object Medium: DeviceScreenType
    object Expanded: DeviceScreenType
    object Foldable: DeviceScreenType
}