package com.example.calculadora

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class KeyboardLayout() {
    @Composable
    fun layout() {

        val keyboard = KeyboardViewComposable()
        val visor = VisorViewComposable()
        var string_operation by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
        ) {

            visor.VisorLayout(string_operation)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .align(Alignment.BottomEnd)
            ) {
                string_operation = keyboard.KeyboardLayout()

            }

            //Log.d("string_operation", string_operation)
        }


    }

}