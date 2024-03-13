package com.example.sitemaster

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun MyToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_SHORT).show()
}
@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var username by remember { mutableStateOf(TextFieldValue()) }
    var role by remember { mutableStateOf("Employee") }
    var phonenumber by remember { mutableStateOf(TextFieldValue()) }

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.hand))
    var isPlaying by remember {
        mutableStateOf(true)
    }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )
    LaunchedEffect(key1 = progress) {
        if (progress == 0f){
            isPlaying = true
        }
        if (progress == 1f){
            isPlaying = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00CCCC)),
//            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val myfont = FontFamily(
            Font(R.font.irish, FontWeight.Black)
        )
        Row (
            modifier = Modifier.offset(y = 15.dp, x = 20.dp)
        ){
            Text(
                text = "Site Master",
                fontSize = 30.sp,
                fontFamily = myfont,
                color = Color.White,
//                modifier = Modifier.offset(x = 50.dp),
                textAlign = TextAlign.Center
            )
//            Spacer(modifier = Modifier.width(5.dp))
//            LottieAnimation(
//                modifier = Modifier
//                    .size(60.dp)
//                    .offset(x = 70.dp) ,
////                .offset(y = 133.dp),
//                composition = composition,
//                alignment = Alignment.TopCenter,
//                progress = { progress }
//            )

        }
        Spacer(modifier = Modifier.height(50.dp))

        // Username field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Name", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = Color.White), // Set border thickness and color
        )

        Spacer(modifier = Modifier.size(28.dp))

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email", color = Color.White, fontSize = 20.sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = Color.White), // Set border thickness and color
        )
        Spacer(modifier = Modifier.height(28.dp))

        // Phone number field
        OutlinedTextField(
            value = phonenumber,
            onValueChange = { phonenumber = it },
            label = { Text(text = "Phone Number", color = Color.White, fontSize = 20.sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = Color.White), // Set border thickness and color
        )

//        Spacer(modifier = Modifier.size(16.dp))

        // Role selection (radio buttons)
        var showEmployeeIdPopup by remember { mutableStateOf(false) }
        var showPopup by remember { mutableStateOf(false) }
        var popupMessage by remember { mutableStateOf("") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RadioButton(
                selected = role == "Employee",
                onClick = {
                    role = "Employee"
                    showEmployeeIdPopup = true // Show popup when Employee is selected
                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.White)
            )
            Text(text = "Employee", modifier = Modifier.offset(y = 10.dp), color = Color.White)

            RadioButton(
                selected = role == "Contractor",
                onClick = {
                    role = "Contractor"
                    showEmployeeIdPopup = false // Hide popup when Contractor is selected
                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.White, unselectedColor = Color.DarkGray)
            )
            Text(text = "Contractor", modifier = Modifier.offset(y = 8.dp), color = Color.White)
        }

        var employeeId by remember { mutableStateOf("") }

        if (showEmployeeIdPopup) {
            AlertDialog(
                onDismissRequest = { showEmployeeIdPopup = false },
                title = { Text(text = "Enter Employee ID") },
                text = {
                    OutlinedTextField(
                        value = employeeId,
                        onValueChange = { employeeId = it },
                        label = { Text("Employee ID") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(onClick = {
                        if (employeeId.isBlank()) {
                            // Show a popup message if Employee ID field is empty
                            popupMessage = "Unexpected error: field is empty...🥲...🤔"
                            showPopup = true
                        } else {
                            // Show a popup message if Employee ID is filled
                            popupMessage = "Employee ID filled successfully...🥂...🎉"
                            showPopup = true
                            showEmployeeIdPopup = false // Dismiss the popup after successful submission
                        }
                    }) {
                        Text("Submit")
                    }
                }
            )
        }

        if (showPopup) {
            CustomPopup(message = popupMessage) {
                showPopup = false
            }
        }
        Spacer(modifier = Modifier.size(16.dp))

        // Continue button
//        Button(
//            onClick = {
//                navController.navigate("host")
//            }, modifier = Modifier
//                .padding(horizontal = 120.dp, vertical = 110.dp)
//                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.White)
//        ) {
//            Text(text = "Continue", fontFamily = myfont, color = Color(0xFF0D6446), textAlign = TextAlign.Center)
//            Alignment.Center
//        }
        // Inside the LoginScreen composable
        Button(
            onClick = {
                navController.navigate("host/$role") {
                    launchSingleTop = true
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
            },
            modifier = Modifier
                .padding(horizontal = 120.dp, vertical = 110.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(text = "Continue", fontFamily = myfont, color = Color(0xFF00CCCC), textAlign = TextAlign.Center)
        }



    }
}

@Composable
fun CustomPopup(message: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Verification") },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}

//@Preview
//@Composable
//fun PreviewLoginScreen() {
//    LoginScreen { isContractor ->
//        ProjectsPage(isContractor)
//    }
//}

