package com.btab.kidsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.btab.kidsapp.ui.navigation.NavigationHost
import com.btab.kidsapp.ui.theme.KidsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KidsAppTheme {
                NavigationHost()
            }
        }
    }
}

