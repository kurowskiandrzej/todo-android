package com.kurowskiandrzej.todoandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: MainUseCases
) : ViewModel() {
    var isUserAuthenticated = false
    var isDataFetched = false

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val (accessToken, _) = useCases.getAccessAndRefreshTokens()
            if (accessToken != null) {
                isUserAuthenticated = true

                val fetchDataResult = useCases
                    .fetchData(token = accessToken)
            }

            isDataFetched = true
        }
    }
}