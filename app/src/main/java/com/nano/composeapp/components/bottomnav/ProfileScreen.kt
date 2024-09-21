package com.nano.composeapp.components.bottomnav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nano.composeapp.sealed.BottomNavigationScreens
import com.nano.composeapp.ui.theme.notoSansFontFamily

/**
 * Created By Neeraj Yadav on 20/09/24
 */

@Composable
fun ProfileScreen(){
    Scaffold {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()){
            Text(
                text = BottomNavigationScreens.Profile.route,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                fontFamily = notoSansFontFamily,
                fontWeight = FontWeight.Bold
            )
        }

    }
}