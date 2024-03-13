package com.example.sitemaster

//import com.example.sitemaster.NewUser
//import com.example.sitemaster.Project
//import com.example.sitemaster.R
//import com.example.sitemaster.sampleProjects


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


val sampleProjects = listOf(
    Project(
        "Project 1",
        "Description of project 1",
        listOf(
            Worker("John Doe", "+1234567890"),
            Worker("Jane Smith", "+9876543210")
        )
    ),
    Project(
        "Project 2",
        "Description of project 2",
        listOf(
            Worker("Morris Nthekani", "+4457890110"),
            Worker("Cicilia Nthenya", "+254790674532")
        )
    ),
    Project(
        "Project 3",
        "Description of project 3",
        listOf(
            Worker("Caleb Yusuf", "+47890278945"),
            Worker("Kendi Mumbi", "+254782345190")
        )
    ),
)


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationDrawerExample(navController: NavHostController, isContractor: Boolean){
val user = NewUser(username = "John Doe", email = "john.doe@example.com")
    val coroutineScope = rememberCoroutineScope()
    var isDarkModeOn by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)


    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Profile picture
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.Blue) .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Username
                Text(
                    text = user.username,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Email
                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.weight(1f))

                // Dark mode switch
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Dark Mode",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                    DarkModeSwitch(isDarkModeOn = isDarkModeOn) {
                        isDarkModeOn = !isDarkModeOn
                    }
//                    Switch(
//                        checked = isDarkModeOn,
//                        onCheckedChange = { /* Handle dark mode toggle */ }
//                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Privacy policy
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Privacy Policy",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Privacy Policy",
                        modifier = Modifier.clickable { navController.navigate("privacy")}
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // More about us
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "More About Us",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "More About Us",
                        modifier = Modifier.clickable { navController.navigate("about") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Logout button
                Button(
                    onClick = {  navController.navigate("sign_in")},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Logout")
                }
            }
        }

    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Projects") },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        } }
                )
            },
            floatingActionButton = {
                if (isContractor) {
                    FloatingActionButton(
                        onClick = {
                            // Action to add new project
                        },
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Project",
                            tint = Color(0xFF00CCCC)
                        )
                    }
                }else {
                    // Placeholder for when isContractor is false
                    Box(modifier = Modifier.padding(0.dp)) // Empty Box to maintain layout
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProjectList(projects = sampleProjects, navController = navController)
            }
        }
    }
}

@Composable
fun ProjectList(projects: List<Project>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(projects) { project ->
            ProjectCard(project = project, navController = navController)
        }
    }
}

@Composable
fun ProjectCard(project: Project, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                val projectName = project.name
                // Navigate to project details screen with project name
                navController.navigate("project_details?projectName=${project.name}")

            }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = project.name, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = project.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProjectDetails(projectName: String?, viewModel: ProjectDetailsViewModel) {
    val project = viewModel.project.collectAsState().value
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = projectName ?: "Project Details") } // Use default if null
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Project name and description
            Text(
                text = project.project?.description ?: "No description available",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Worker list as a Table
            Text(text = "Workers", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

            // Assuming project.workers is a list of Worker objects
            WorkerTable(workers = project.project?.workers ?: emptyList())

            Spacer(modifier = Modifier.weight(1f))

            // Button to print users
            Button(onClick = {
                coroutineScope.launch {
                    // Access SnackbarHostState through scaffoldState
                    scaffoldState.snackbarHostState.showSnackbar("Users Printed")
                }
            }) {
                Text("Print Users")
            }
        }
    }
}

@Composable
fun WorkerTable(workers: List<Worker>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Text(
                text = "Username  |  Phone Number",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        items(workers) { worker ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(text = worker.username, style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(1f))
                Text(text = worker.phoneNumber, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}



@Composable
fun DarkModeSwitch(isDarkModeOn: Boolean, onDarkModeToggle: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Dark Mode", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isDarkModeOn,
            onCheckedChange = { onDarkModeToggle() },
            colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.secondary)
        )
    }
}

