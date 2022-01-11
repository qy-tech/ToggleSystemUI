package com.qytech.togglesystemui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomePage() {
    var show by remember { mutableStateOf(true) }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            show = !show
            toggleSystemUI(context, show)
        }) {
            Text(
                text = if (show) "hide system ui" else "show system ui",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
    }

}

@Preview()
@Composable
fun HomePagePreview() {
    HomePage()
}

/**
 * toggle NavigationBar and StatusBar by broadcast
 * @param context context
 * @param show
 *  if true show NavigationBar and StatusBar
 *  if false hide NavigationBar and StatusBar
 * */
private fun toggleSystemUI(context: Context, show: Boolean) {
    val intent = Intent("android.intent.action.action_navigation_bar")
    intent.putExtra("show", show)
    context.sendBroadcast(intent)
}