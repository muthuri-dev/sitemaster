package com.example.sitemaster

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.X
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
@SuppressLint("RememberReturnType")
@Composable
fun AboutUsScreen(navController: NavHostController) {
//    val animatedOffset = remember { Animatable(0f) }
//
//    LaunchedEffect(Unit) {
//        animatedOffset.a(1f, tween(durationMillis = 800))
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color(0xFF00CCCC))
    ) {
        Text(
            text = "Welcome to Site Masters",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .animateContentSize() // Enable size animation for shimmers
        )
        Text(
            text = "Welcome to Site Masters",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp) .animateContentSize()
        )
        Text(
            text = "Where expertise meets excellence in construction services.",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "With a rich legacy of craftsmanship spanning decades, we specialize in delivering innovative solutions tailored to your project needs.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "Our dedicated team of professionals is committed to ensuring the highest standards of quality, safety, and sustainability in every endeavor.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "From residential developments to commercial complexes, our portfolio showcases a diverse range of successful projects.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "At Site Masters, we prioritize client satisfaction, fostering lasting partnerships built on trust and integrity.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "Together, we shape the landscape, envisioning and constructing spaces that inspire and endure.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
        Text(
            text = "Join us on this journey of building dreams into reality, one project at a time.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp) .animateContentSize()
        )
    }
}
