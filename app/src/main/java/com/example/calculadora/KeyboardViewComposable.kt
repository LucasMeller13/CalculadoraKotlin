package com.example.calculadora

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Collections.list

class KeyboardViewComposable {

    @Composable
    fun KeyboardLayout(): Pair<String, String> {

        var string_operation by remember { mutableStateOf("") }
        var string_result by remember { mutableStateOf("") }

        try {
            string_result = calculateOperation(string_operation)
        }catch (e : Exception){
            null
        }

        //Log.d("string_operation", string_operation)
        createButtonsLayout(listOf("1", "2", "3", "+"), string_operation, onOperationChange = { string_operation = it })
        createButtonsLayout(listOf("4", "5", "6", "-"), string_operation, onOperationChange = { string_operation = it })
        createButtonsLayout(listOf("7", "8", "9", "*"), string_operation, onOperationChange = { string_operation = it })
        createButtonsLayout(listOf("C", "0", "=", "/"), string_operation, onOperationChange = { string_operation = it })
        Log.d("string_operation", string_operation)
        Log.d("string_operation_length", string_operation.length.toString())
        return Pair(string_operation, string_result)

    }

    @Composable
    fun createButtonsLayout(listString : List<String>, string_operation : String,onOperationChange: (String) -> Unit){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for(string in listString) {
                Button(
                    onClick = {
                        if (string == "C") {
                            onOperationChange("")
                        } else if (string_operation.length == 0 && (checkOperation(string,0))) {
                            onOperationChange("")
                        }
                        else if (string_operation.length > 0 && checkOperation(string,1) && checkOperation(string_operation.last().toString(),1)) {
                            onOperationChange(string_operation + "")
                        }
                        else {
                            onOperationChange(string_operation + string)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(120.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        text = string,
                        fontSize = 35.sp
                    )
                }
            }
        }
    }

    fun checkOperation(string : String, type : Int): Boolean {
        if(type == 0){
            return (string.contains("+") || string.contains("*") || string.contains("/") || string.contains("="))
        } else if(type == 1){
            return (string.contains("+") || string.contains("-") || string.contains("*") || string.contains("/"))
        }
        return false
    }

    fun calculateOperation(string_operation : String) : String{
        var temp_string_operation = string_operation

        while (temp_string_operation.isNotEmpty() && !temp_string_operation[temp_string_operation.length - 1].isDigit()) {
            temp_string_operation = temp_string_operation.substring(0, temp_string_operation.length - 1)
        }

        var list_single_operation = mutableListOf<String>()
        var list_sign_operation = mutableListOf<String>()
        list_single_operation = temp_string_operation.split("+","-").toMutableList()

        val regex = "[+\\-]"
        val operators = regex.toRegex().findAll(temp_string_operation).map { it.value }.toList()
        list_sign_operation.addAll(operators)

        if(temp_string_operation.first().toString() == "-"){
            list_single_operation[1] = "-" + list_single_operation[1]
            list_single_operation.removeAt(0)
            list_sign_operation.removeAt(0)
        }

        var result = list_single_operation.first()
        var counter = 0

        if(list_single_operation.size == 1){
            result = processDivision(result)
        }else{
            for(string in list_single_operation.subList(1, list_single_operation.size)){
                if(list_sign_operation[counter] == "+"){
                    result = (result.toDouble() + processDivision(string).toDouble()).toString()
                } else if(list_sign_operation[counter] == "-"){
                    result = (result.toDouble() - processDivision(string).toDouble()).toString()
                }
                counter++
            }
        }
        return result
    }

    fun processDivision(stringDivision : String) : String {
        if (!(stringDivision.contains("/") || stringDivision.contains("*"))) {
            return stringDivision
        }
        var list_string = stringDivision.split("r")
        if (stringDivision.contains("/")) {
            list_string = stringDivision.split("/")
        }

        var result_multiplication = 1.0

        for (string in list_string) {
            var temp = string
            if (string.contains("*")) {
                val temp_division = string.split("*")
                var calc = 1.0
                for (x in temp_division) {
                    calc *= x.toDouble()
                }
                result_multiplication = calc
            } else {
                result_multiplication /= temp.toDouble()
            }
        }

        return result_multiplication.toString()
    }

}