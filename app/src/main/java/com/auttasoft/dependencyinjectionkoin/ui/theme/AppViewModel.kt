package com.auttasoft.dependencyinjectionkoin.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by AuttaphonL. on 06,ธันวาคม,2566
 */
class AppViewModel : ViewModel() {
    // MutableState to hold the text value
    var textState: MutableState<String> = mutableStateOf("Default Text")

    fun updateText(newText: String) {
        // Update the MutableState with the new text
        textState.value = newText
    }

    fun fetchData() {
        viewModelScope.launch {
            // Simulate a background task (e.g., network request)
            delay(2000) // Simulating a delay of 2 seconds

            // Update textState with the result
            updateText("Fetched data")
        }
    }
}