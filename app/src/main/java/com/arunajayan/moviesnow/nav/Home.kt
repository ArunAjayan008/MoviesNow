package com.arunajayan.moviesnow.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
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
fun Home() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(colorResource(id = R.color.purple))
            ) {
                item {
                    HeaderSection()
                }
                item {
                    DescSection()
                }
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.download),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
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

        Box(
            modifier = Modifier
                .height(150.dp)
                .padding(15.dp)
                .clip(shape = RoundedCornerShape(25.dp))
                .background(colorResource(id = R.color.alpha))
                .align(Alignment.BottomCenter)
        ) {

            Column(Modifier.padding(15.dp)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .weight(1.0f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Venom 2",
                        fontSize = 18.sp,
                        fontFamily = robotoFamily,
                        color = colorResource(id = R.color.white),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.0f),
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "Share",
                        Modifier.padding(end = 12.dp),
                        tint = colorResource(id = R.color.white)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite_24),
                        contentDescription = "Share",
                        tint = colorResource(R.color.white)
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .weight(1.0f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                            .padding(end = 10.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxHeight()
                            .background(color = colorResource(id = R.color.blue)),
                        contentAlignment = Alignment.Center,
                    ) {
                        BannerDataItem("Action")
                    }
                    Box(
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                            .padding(end = 10.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxHeight()
                            .background(color = colorResource(id = R.color.light_purple)),
                        contentAlignment = Alignment.Center,
                    ) {
                        BannerDataItem("02:45 Hr")
                    }
                    Box(
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                            .padding(end = 10.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxHeight()
                            .background(color = colorResource(id = R.color.yellow)),
                        contentAlignment = Alignment.Center,
                    ) {
                        BannerDataItem("8.8 ⭐")
                    }
                }
            }
        }
    }
}

@Composable
fun BannerDataItem(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        text = text,
        color = colorResource(id = R.color.white),
        fontSize = 14.sp,
        fontFamily = robotoFamily,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Medium,
    )
}

@Composable
fun DescSection() {
    Spacer(Modifier.padding(vertical = 5.dp))
    TitleItem("Overview")
    ParagraphItem("Overview: Directed by Guy Reid. With David Beaver, Ronald Garan, Jeffrey Hoffman, Shane Kimbrough. Astronauts who have seen the Earth from space have often described the 'Overview Effect', an experience that has transformed their perspective of the planet and mankind's place upon it, and enabled them to perceive it as our shared home, without boundaries between nations or species.")
    Spacer(Modifier.padding(vertical = 8.dp))
    TitleItem("Star Cast")
    Spacer(Modifier.padding(vertical = 4.dp))
    CastingListView()
    Spacer(Modifier.padding(vertical = 8.dp))
}

@Composable
fun CastingListView() {
    LazyRow(
        Modifier
            .padding(start = 15.dp)
            .fillMaxWidth()
    ) {
        items(15){
            CastItem()

        }
    }
}

@Composable
fun CastItem() {
    Row {
        Image(
            painter = painterResource(R.drawable.download), contentDescription = "actor",
            Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(100.dp)
                .width(100.dp), contentScale = ContentScale.Crop
        )
        Spacer(modifier=Modifier.width(10.dp))
    }
}

@Composable
fun TitleItem(title: String) {
    Text(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 4.dp),
        text = title,
        color = colorResource(id = R.color.font_purple),
        fontSize = 16.sp,
        fontFamily = robotoFamily,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ParagraphItem(paras: String) {
    Text(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 4.dp),
        text = paras,
        color = colorResource(id = R.color.grey),
        fontSize = 14.sp,
        fontFamily = robotoFamily,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        softWrap = true,
        textAlign = TextAlign.Justify
    )
}

@Preview
@Composable
fun BannerPreview() {
    Home()
}
