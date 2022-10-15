package com.example.googlemeetclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlemeetclone.ui.theme.GoogleMeetCloneTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMeetCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    navigation()
                }

            }
        }
    }
}

@Composable
fun navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){

        composable("splash_screen"){
            DisplaySplashScreen(navController = navController)
        }
        composable("main_screen"){
            HomeScreen()
        }

    }
}

@Composable
fun DisplaySplashScreen(navController: NavController){

    LaunchedEffect(key1 = true){
        delay(5000L)
        navController.navigate("main_screen")
    }

    SplashScreen()

}