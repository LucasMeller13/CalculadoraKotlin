package com.example.calculadora

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class VisorViewComposable {


    @Composable
    fun VisorLayout(string_operation : String, string_visor_result : String){
        val string_visor_operation by rememberUpdatedState(string_operation)
        val string_visor_result by rememberUpdatedState(string_visor_result)

//        Log.d("string_operation", string_operation)
//        Log.d("string_visor_operation", string_visor_operation)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
                .background(Color.Cyan)
                .padding(all = 20.dp)
                .padding(top = 30.dp)
                .padding(bottom = 25.dp)
        ) {
            Text(
                text = string_visor_operation,
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopEnd)
            )

            Text(
                text = string_visor_result,
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
            )
        }
    }

}