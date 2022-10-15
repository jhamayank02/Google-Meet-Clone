package com.example.googlemeetclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlemeetclone.ui.theme.GoogleMeetCloneTheme

class Join : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMeetCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .fillMaxWidth()){

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                    Column(){
                                        Text(text = "Join with a code", fontSize = 20.sp)
                                    }
                                    Column() {
                                        Text(text = "Join", color = Color.Gray)
                                    }
                                }
                            }
                        }

                        Row(modifier = Modifier.padding(top = 25.dp)) {
                            Text(text = "Enter the code provided by the meeting orgainiser", fontSize = 14.sp)
                        }
                        Row(modifier = Modifier
                            .padding(top = 15.dp)
                            .width(400.dp)) {
                            var text by remember { mutableStateOf(TextFieldValue("")) }
                            TextField(
                                value = text,
                                onValueChange = { it ->
                                    text = it
                                },
                                placeholder = { Text(text = "Example: abc-mnop-xyz") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                }
            }
        }
    }
}
}