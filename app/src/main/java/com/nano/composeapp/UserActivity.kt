package com.nano.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nano.composeapp.components.buttons.ButtonCompose
import com.nano.composeapp.components.input.TextInputCompose
import com.nano.composeapp.ui.theme.ComposeAppTheme

class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {
                //FlowerScreenLogin()
                //UserProfileScreen()
                //ComposeRelatedApp()
                //ButtonCompose()
                TextInputCompose()
            }
        }
    }
}