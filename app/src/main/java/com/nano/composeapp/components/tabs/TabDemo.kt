package com.nano.composeapp.components.tabs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created By Neeraj Yadav on 25/09/24
 */
@Composable
fun TabDemo() {
    Scaffold { innerPadding->
        // State to track the selected tab index
        var selectedTabIndex by remember { mutableStateOf(0) }

        // Tab titles
        val tabTitles = listOf("Tab 1", "Tab 2", "Tab 3")

        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth().padding(innerPadding)
        ) {
            // Create tabs
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TabDemoPreview() {
    TabDemo()
}