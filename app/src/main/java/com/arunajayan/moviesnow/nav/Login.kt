package com.arunajayan.moviesnow.nav

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arunajayan.moviesnow.R
import com.arunajayan.moviesnow.robotoFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    val animScale = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(key1 = true) {
        animScale.animateTo(
            targetValue = 1f,
            animationSpec = tween(delayMillis = 500, durationMillis = 1000, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
    }
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .background(colorResource(id = R.color.purple)),
                        contentAlignment = Alignment.Center
                    ) {
                        LoginBackground()
                        ContentSection(animScale)
                    }

                }
            }
        }
    }
}

@Composable
fun LoginBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.transparent))
    ) {
        Image(painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "Banner",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer { alpha = 0.99f }
                .drawWithContent {
                    val colors = listOf(
                        Color.Black, Color.Transparent
                    )
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors), blendMode = BlendMode.DstIn
                    )
                })
    }
}


@Composable
fun ContentSection(animScale: Animatable<Float, AnimationVector1D>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppTitleSection(animScale)
        AppCTASection()
    }
}

@Composable
fun AppTitleSection(animScale: Animatable<Float, AnimationVector1D>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .rotate(-20f)
                .clip(shape = RoundedCornerShape(10.dp, 20.dp, 10.dp, 20.dp))
                .background(color = colorResource(id = R.color.logo_purple)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 5.dp)
                    .rotate(20f)
                    .height(55.dp)
                    .width(55.dp)
                    .scale(animScale.value),
                painter = painterResource(id = R.drawable.ic_play_button),
                contentDescription = "Icon",
                tint = colorResource(id = R.color.white)
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            text = "MoviesNow",
            color = colorResource(id = R.color.light_purple),
            fontSize = 35.sp,
            fontFamily = robotoFamily,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            modifier = Modifier.padding(horizontal = 40.dp, vertical = 10.dp),
            text = "Watch unlimited movies, series & TV shows anywhere, anytime",
            color = colorResource(id = R.color.white),
            fontSize = 16.sp,
            fontFamily = robotoFamily,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 25.sp,
            softWrap = true,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun AppCTASection() {
    Column(Modifier.padding(bottom = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = {
                // click event
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.font_purple))
        ) {
            Text(
                modifier = Modifier.padding(5.dp), text = "LOGIN",
                fontSize = 14.sp,
                fontFamily = robotoFamily,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = {
                // click event
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_grey))
        ) {
            Text(
                modifier = Modifier.padding(5.dp), text = "SKIP NOW",
                fontSize = 14.sp,
                fontFamily = robotoFamily,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Text(
            modifier = Modifier.padding(top=15.dp), text = "Don't have an account? Signup now",
            fontSize = 12.sp,
            fontFamily = robotoFamily,
            letterSpacing = 0.sp,
            color = colorResource(id = R.color.yellow),
            fontWeight = FontWeight.Light,
        )
    }
}


@Preview
@Composable
fun LoginPreview() {
    Login()
}