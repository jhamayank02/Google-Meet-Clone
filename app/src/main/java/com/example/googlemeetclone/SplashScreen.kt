package com.example.googlemeetclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(){

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

        Row(
            modifier = Modifier.padding(top = 260.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_meet_logo),
                contentDescription = "Google Meet Logo",
                modifier = Modifier.size(150.dp)
            )
        }

        Row(modifier = Modifier.padding(top = 260.dp)) {
            Text(
                text = "Google",
                fontSize = 33.sp,
                color = Color(97, 96, 96),
                fontWeight = FontWeight.W600

            )
            Text(
                text = " Workspace",
                fontSize = 33.sp,
                color = Color(97, 96, 96)
            )
        }
    }
}