package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    Column {
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter")      //This is used to display text on the screen
        OutlinedTextField(value = "", onValueChange = {
            // Here goes what should happen when the Value of our OutlinedTextField changes, this is an anonymous function means a function with no name
        })
        Row {
            val context = LocalContext.current      // In order to create a toast we need to have the context in which the toast is displayed, LocalContext means the toast should run in the app only
            // Here all the UI elements will be stacked next to each other
            Button(onClick = {Toast.makeText(context,"Thanks for clicking",Toast.LENGTH_LONG).show()}) {    //We need to show() a toast after its creation
                Text(text = "Click Me")
            }
        }
        Text("Result:")
    }
}

@Preview(showBackground = true)        //Used to preview the app without running it
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}