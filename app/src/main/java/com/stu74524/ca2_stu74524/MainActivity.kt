package com.stu74524.ca2_stu74524

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stu74524.ca2_stu74524.ui.theme.SimpleNavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNavigationTheme {
                AppNavigation()
            }
        }
    }
}