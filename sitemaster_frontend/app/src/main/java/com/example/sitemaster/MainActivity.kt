package com.example.sitemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sitemaster.ui.theme.SitemasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash_screen") {
                composable("splash_screen") {
//                        navController.popBackStack()
                    SplashScreen(navController = navController)

                }
                composable("sign_in"){
                    LoginScreen(navController = navController)
                }
                composable("privacy"){
                    TypewriterScreen(navController = navController)
                }
                composable("about"){
                    AboutUsScreen(navController = navController)
                }
                composable("host/{role}") { backStackEntry ->
                    val role = backStackEntry.arguments?.getString("role")
                    // Pass the role to the NavigationDrawerExample composable
                    NavigationDrawerExample(navController = navController, isContractor = role == "Contractor")
                }
                composable("project_details?projectName={projectName}") { backStackEntry ->
                    val projectName = backStackEntry.arguments?.getString("projectName") ?: ""
                    // Show ProjectDetails screen with the retrieved project name
                    val project = sampleProjects.find { it.name == projectName }

                    if (project != null) {
                        ProjectDetailsScreen(project = project)
                    }
                }

            }

            }
        }
}

