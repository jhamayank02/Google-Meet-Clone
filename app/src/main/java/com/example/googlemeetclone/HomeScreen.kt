package com.example.googlemeetclone

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState =
    BottomSheetState(BottomSheetValue.Collapsed))

    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Card(elevation = 10.dp) {

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.White)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.link),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(end = 10.dp)
                            )
                            Text(
                                text = "Get a meeting link to share",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.W600
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.video),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(end = 10.dp)
                            )
                            Text(
                                text = "Start an instant meeting",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.W600
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.calendar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(end = 10.dp)
                            )
                            Text(
                                text = "Schedule in Google Calendar",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.W600
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.close),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(end = 10.dp)
                            )
                            Text(
                                text = "Close",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp
    ){}

        Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        val context = LocalContext.current

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Text(text = "☰", fontSize = 23.sp)
            Text(text = "Meet", fontSize = 25.sp)

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(168, 49, 163)),
                modifier = Modifier.size(35.dp),  //avoid the oval shape
                shape = CircleShape,
                border = BorderStroke(1.dp, Color(168, 49, 163)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "M", color = Color.White)
            }

        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                .padding(top = 20.dp, start = 15.dp, end = 5.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        }else{
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier.width(175.dp),
                colors = ButtonDefaults.buttonColors(Color(50, 59, 184))
            ) {
                Text(text = "New meeting", color = Color.White)
            }
            Button(
                onClick = { /*TODO*/
                    GoToJoin(context)
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier.width(175.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(1.dp, Color(50, 59, 184))
            ) {
                Text(text = "Join with a code", color = Color(50, 59, 184))
            }

        }

    }
    Row(modifier = Modifier.padding(top = 260.dp)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.google_meet_logo),
                contentDescription = "Google Meet Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 5.dp)
            )

            Row(
                modifier = Modifier
                    .width(250.dp)
                    .padding(bottom = 5.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Get a link that you can share",
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center
                )
            }

            Row(modifier = Modifier.width(270.dp)) {
                Text(
                    text = "Tap New Meeting to get a link that you can send to people that you want to meet with",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
}

fun GoToJoin(context: Context){
    val navigate = Intent(context, Join::class.java)
    context.startActivity(navigate)
}