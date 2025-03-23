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
        var string_result by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
        ) {

            visor.VisorLayout(string_operation, string_result)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .align(Alignment.BottomEnd)
            ) {
                val (new_operation, new_result) = keyboard.KeyboardLayout()
                string_operation = new_operation
                string_result = new_result

            }

            //Log.d("string_operation", string_operation)
        }


    }

}