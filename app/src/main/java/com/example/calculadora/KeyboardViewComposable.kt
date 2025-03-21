package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class KeyboardLayout(){
    @Composable
    fun layout(){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow),

        ) {
            Text(
                text = "visor teste",
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button({},
                    modifier = Modifier.size(50.dp)) {
                    Text(
                        text = "1"
                    )
                }
                Button({}) {
                    Text(
                        text = "2"
                    )
                }
                Button({}) {
                    Text(
                        text = "3"
                    )
                }
                Button({}) {
                    Text(
                        text = "+"
                    )
                }
            }

            Row {
                Button({}) {
                    Text(
                        text = "4"
                    )
                }
                Button({}) {
                    Text(
                        text = "5"
                    )
                }
                Button({}) {
                    Text(
                        text = "6"
                    )
                }
                Button({}) {
                    Text(
                        text = "-"
                    )
                }
            }

            Row {
                Button({}) {
                    Text(
                        text = "7"
                    )
                }
                Button({}) {
                    Text(
                        text = "8"
                    )
                }
                Button({}) {
                    Text(
                        text = "9"
                    )
                }
                Button({}) {
                    Text(
                        text = "*"
                    )
                }
            }

            Row {
                Button({}) {
                    Text(
                        text = "C"
                    )
                }
                Button({}) {
                    Text(
                        text = "0"
                    )
                }
                Button({}) {
                    Text(
                        text = "="
                    )
                }
                Button({}) {
                    Text(
                        text = "/"
                    )
                }
            }

        }


    }

}