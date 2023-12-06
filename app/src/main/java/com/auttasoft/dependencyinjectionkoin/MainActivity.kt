package com.auttasoft.dependencyinjectionkoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.auttasoft.dependencyinjectionkoin.ui.theme.AppViewModel
import com.auttasoft.dependencyinjectionkoin.ui.theme.DependencyInjectionKoinTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionKoinTheme {
                // Compose UI components go here
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val viewModel: AppViewModel = getViewModel()
    val observableName by remember { viewModel.textState }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = observableName,
            onValueChange = {
                viewModel.updateText(it)
            },
            label = { Text("Enter your name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        // Display the text from the ViewModel
        Text(
            text = observableName,
            modifier = Modifier.padding(8.dp)
        )
    }
}