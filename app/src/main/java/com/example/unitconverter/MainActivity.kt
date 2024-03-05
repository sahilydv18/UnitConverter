package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize(),  //It fits the column to the max size it requires
        verticalArrangement = Arrangement.Center,   //It vertically arranges the content of the column
        horizontalAlignment = Alignment.CenterHorizontally   //It horizontally aligns the content of the column
    ) {   // Here all the UI elements will be stacked below each other
        Text("Unit Converter") //This is used to display text on the screen
        Spacer(modifier = Modifier.height(16.dp))   //A spacer is used to give space between two UI components, its advantage is that it can be reused for many UI components
        OutlinedTextField(value = "", onValueChange = {
            // Here goes what should happen when the Value of our OutlinedTextField changes, this is an anonymous function means a function with no name
        })
        Spacer(modifier = Modifier.height(16.dp))   //like here
        Row {  // Here all the UI elements will be stacked next to each other
//            val context = LocalContext.current      // In order to create a toast we need to have the context in which the toast is displayed, LocalContext means the toast should run in the app only
//            Button(onClick = {Toast.makeText(context,"Thanks for clicking",Toast.LENGTH_LONG).show()}) {    //We need to show() a toast after its creation
//                Text(text = "Click Me")
//            }
            Box {   //This is needed to create a drop down menu, as we want everything in the same context be it button for opening the drop down menu and the drop down menu itself
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")    //Adding the arrow down icon using this, contentDescription means what the icon means this is used in accessibility
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {   //This is used to create a drop down menu, expanded means that if the menu will be opened by default or not and onDismissRequest means what should happen when the menu closes
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {   //This is needed to create a drop down menu
                Button(onClick = { /*TODO*/ }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")    //Adding the arrow down icon using this, contentDescription means what the icon means this is used in accessibility
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/ })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))   //like here
        Text("Result:")
    }
}

@Preview(showBackground = true)        //Used to preview the app without running it
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}