package com.example.sitemaster

import android.annotation.SuppressLint
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProjectDetailsScreen(project: Project) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = project.name ?: "Project Details") } // Use default if null
            )
        }
    ) {
        // Content of the screen
        Text(text = "Project description: ${project.description}")
    }
}
