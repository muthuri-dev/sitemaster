package com.example.sitemaster

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec= tween(
            durationMillis = 3500
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(6500)
        navController.popBackStack()
        navController.navigate("sign_in")
    }
    LandingPage(alpha = alphaAnim.value)
}
@Composable
fun LandingPage(alpha: Float){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.build))
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
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00CCCC)),
        Alignment.CenterStart

    ) {
        LottieAnimation(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
//                .offset(y = 133.dp),
            composition = composition,
            alignment = Alignment.TopCenter,
            progress = { progress }
        )
        Row (
            modifier = Modifier.align(Alignment.Center)
        ){
            val myfont = FontFamily(
                Font(R.font.irish, FontWeight.Black)
            )
            Text(
                text = "Site Master",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontFamily = myfont,
                    lineHeight = 55.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                ),
                modifier = Modifier.padding(horizontal = 62.dp)
            )
        }
    }

}