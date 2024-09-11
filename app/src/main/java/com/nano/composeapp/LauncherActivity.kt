package com.nano.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nano.composeapp.ui.theme.ComposeAppTheme

class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {
                ComposeRelatedApp()
                //ButtonCompose()
                //TextInputCompose()
                //TopBarSmall()
                //TopAppBarCentreAligned()
                //AppBarMedium()
                //TopAppBarLarge()
                //CardComponent()
            }
        }
    }
}