package com.example.sitemaster

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DrawerValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ProjectsPage(isContractor: Boolean) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Projects")
//                },
//                actions = {
//                    IconButton(onClick = { /* Handle navigation */ }) {
//                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
//                    }
//                }
//            )
//        },
//
//        floatingActionButton = {
//            if (isContractor) {
//                FloatingActionButton(
//                    onClick = {
//                        // Action to add new project
//                    },
//                    modifier = Modifier.padding(16.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Add,
//                        contentDescription = "Add Project"
//                    )
//                }
//            }
//        },
//        floatingActionButtonPosition = FabPosition.End,
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            ProjectList(projects = sampleProjects)
//        }
//    }
//}

//@Composable
//fun CustomPopup(message: String, onDismiss: () -> Unit) {
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        title = { Text(text = "Verification") },
//        text = { Text(text = message) },
//        confirmButton = {
//            Button(onClick = onDismiss) {
//                Text("OK")
//            }
//        }
//    )
//}

//@Composable
//fun ProjectList(projects: List<Project>) {
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        contentPadding = PaddingValues(8.dp)
//    ) {
//        items(projects) { project ->
//            ProjectCard(project = project)
//        }
//    }
//}
//
//@Composable
//fun ProjectCard(project: Project) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        elevation = CardDefaults.cardElevation(8.dp),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Text(text = project.name, style = MaterialTheme.typography.bodySmall)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = project.description, style = MaterialTheme.typography.bodySmall)
//        }
//    }
//}
//



