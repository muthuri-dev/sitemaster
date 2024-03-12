package com.example.sitemaster

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Preview
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var role by remember { mutableStateOf("Employee") }
    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }

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
            .background(color = Color(0xFF0D6446)),
//            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val myfont = FontFamily(
            Font(R.font.irish, FontWeight.Black)
        )
        Row {
            Text(
                text = "Hello there",
                fontSize = 30.sp,
                fontFamily = myfont,
                color = Color.White,
                modifier = Modifier.offset(x = 50.dp),
                textAlign = TextAlign.Center
            )
//            Spacer(modifier = Modifier.width(5.dp))
            LottieAnimation(
                modifier = Modifier
                    .size(60.dp) .offset(x = 70.dp) ,
//                .offset(y = 133.dp),
                composition = composition,
                alignment = Alignment.TopCenter,
                progress = { progress }
            )


        }


        Spacer(modifier = Modifier.height(50.dp))

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .border(width = 2.dp, color = Color.White), // Set border thickness and color
        )

        Spacer(modifier = Modifier.size(28.dp))

// First name field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password", color = Color.White, fontSize = 20.sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally)
                .border(width = 2.dp, color = Color.White), // Set border thickness and color
        )
        Spacer(modifier = Modifier.height(28.dp) )

        Row {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text(text = "First Name", color = Color.White) },
                modifier = Modifier.fillMaxWidth(0.4f) .border(width = 2.dp, color = Color.White)
            )
            Spacer(modifier = Modifier.width(5.dp) )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text(text = "Last Name", color = Color.White) },
                modifier = Modifier.border(width = 2.dp, color = Color.White)
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Role selection (radio buttons)
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            var role by remember { mutableStateOf("Employee") }
//            var employeeId by remember { mutableStateOf("") }
//            var contractorId by remember { mutableStateOf("") }
//
//            RadioButton(
//                selected = role == "Employee",
//                onClick = { role = "Employee" },
//                colors = RadioButtonDefaults.colors(selectedColor = Color.White)
//            )
//            Text(text = "Employee", modifier = Modifier.offset(y=10.dp), color = Color.White)
//            RadioButton(
//                selected = role == "Contractor",
//                onClick = { role = "Contractor" },
//                colors = RadioButtonDefaults.colors(selectedColor = Color.White, unselectedColor = Color.DarkGray)
//            )
//            Text(text = "Contractor", modifier = Modifier.offset(y=8.dp), color = Color.White)
//        }
        var role by remember { mutableStateOf("Employee") }
        var employeeId by remember { mutableStateOf("") }
        var contractorId by remember { mutableStateOf("") }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(
                selected = role == "Employee",
                onClick = { role = "Employee" },
                colors = RadioButtonDefaults.colors(selectedColor = Color.White)
            )
            Text(
                text = "Employee",
                modifier = Modifier.offset(y = 10.dp),
                color = Color.White
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(
                selected = role == "Contractor",
                onClick = { role = "Contractor" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.White,
                    unselectedColor = Color.DarkGray
                )
            )
            Text(
                text = "Contractor",
                modifier = Modifier.offset(y = 10.dp),
                color = Color.White
            )
        }

        if (role == "Employee") {
            // Show a dialog to input employeeId
            TextField(
                value = employeeId,
                onValueChange = { employeeId = it },
                label = { Text("Employee ID") },
                modifier = Modifier.padding(16.dp)
            )
        } else if (role == "Contractor") {
            // Show a dialog to input contractorId
            TextField(
                value = contractorId,
                onValueChange = { contractorId = it },
                label = { Text("Contractor ID") },
                modifier = Modifier.padding(16.dp)
            )
        }



        Spacer(modifier = Modifier.size(16.dp))

        // Continue button
       Button(
            onClick = {
                // Handle login logic here
            }, modifier = Modifier.padding(horizontal = 120.dp, vertical = 110.dp) .fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.White)

        ) {
            Text(text = "Continue", fontFamily = myfont, color = Color(0xFF0D6446), textAlign = TextAlign.Center)
           Alignment.Center
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
