package com.jomacoba.tweetui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TweetScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Header()
        TweetCard()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {
            IconButton(onClick = { activity.finish() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
            Text(text = "Post", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth(),
            color = Color(0xFFE0E0E0)
        )
    }
}

@Composable
fun TweetCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        TweetHeader()
        TweetBody()
        TweetFooter()
    }
}

@Composable
fun TweetHeader(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            Text(text = "John Doe", fontWeight = FontWeight.SemiBold, lineHeight = 2.sp)
            Text(text = "@johndoe", fontSize = 12.sp, color = Color(0xFF808080), lineHeight = 2.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "More options",
                tint = Color(0xFF808080)
            )
        }
    }
}

@Composable
fun TweetBody(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = "Explorando la magia de Jetpack Compose para crear interfaces modernas y dinámicas en Android. #AndroidDev #Compose",
            textAlign = TextAlign.Justify,
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = "7:20 AM · 12 Dec 24", fontSize = 12.sp, color = Color(0xFF808080))
        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .padding(bottom = 2.dp), color = Color(0xFFE0E0E0)
        )
    }
}

@Composable
fun TweetFooter(modifier: Modifier = Modifier) {
    var like by remember { mutableStateOf(false) }
    var countLike by remember { mutableIntStateOf(0) }
    var rt by remember { mutableStateOf(false) }
    var countRt by remember { mutableIntStateOf(3) }
    var comment by remember { mutableStateOf(false) }
    var countComment by remember { mutableIntStateOf(2) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    comment = !comment
                    if (comment) countComment++ else countComment--
                }) {
                    Icon(
                        painter = painterResource(id = if (comment) R.drawable.ic_chat_filled else R.drawable.ic_chat),
                        contentDescription = "Chat",
                        tint = Color(color = if (comment) 0xFF000000 else 0xFF808080)
                    )
                }
                Text(text = countComment.toString(), fontSize = 12.sp, color = Color(0xFF808080))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    like = !like
                    if (like) countLike++ else countLike--
                }) {
                    Icon(
                        painter = painterResource(id = if (like) R.drawable.ic_like_filled else R.drawable.ic_like),
                        contentDescription = "Like",
                        tint = Color(color = if (like) 0xFFe02828 else 0xFF808080)
                    )
                }
                Text(text = countLike.toString(), fontSize = 12.sp, color = Color(0xFF808080))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton({
                    rt = !rt
                    if (rt) countRt++ else countRt--
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rt),
                        contentDescription = "RT",
                        tint = Color(color = if (rt) 0xFF000000 else 0xFF808080)
                    )
                }
                Text(text = countRt.toString(), fontSize = 12.sp, color = Color(0xFF808080))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "Share",
                        tint = Color(0xFF808080)
                    )
                }
            }
        }
        HorizontalDivider(modifier = Modifier.height(1.dp), color = Color(0xFFE0E0E0))
    }
}