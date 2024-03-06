package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("") }   // A state for the input value
    var outputValue by remember { mutableStateOf("") }  // A state for the output value
    var inputUnit by remember { mutableStateOf("Meters") } // A state for the input unit, taking default value as meters
    var outputUnit by remember { mutableStateOf("Meters") } // State for the output unit, taking default value as meters
    var iExpanded by remember { mutableStateOf(false) } // State whether the input drop down menu is extended or not
    var oExpanded by remember { mutableStateOf(false) } // State whether the output drop down menu is extended or not
    val iConversionFactor = remember { mutableDoubleStateOf(1.00) }  // State for the input conversion factor used to convert the values
    val oConversionFactor = remember { mutableDoubleStateOf(1.00) }  // State for the output conversion factor used to convert the values

    fun convertUnits() {        // Function for conversion of values
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0   // This function(toDoubleOrNull) returns value if provided or else return null
        val result = ((inputValueDouble * iConversionFactor.doubleValue * 100.0) / oConversionFactor.doubleValue).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),  //It fits the column to the max size it requires
        verticalArrangement = Arrangement.Center,   //It vertically arranges the content of the column
        horizontalAlignment = Alignment.CenterHorizontally   //It horizontally aligns the content of the column
    ) {   // Here all the UI elements will be stacked below each other

        Text("Unit Converter", style = MaterialTheme.typography.headlineLarge) //This is used to display text on the screen, style = MaterialTheme.typography.headlineLarge is used to change the font of the text

        Spacer(modifier = Modifier.height(16.dp))   //A spacer is used to give space between two UI components, its advantage is that it can be reused for many UI components

        OutlinedTextField(
            value = inputValue,
            onValueChange = {
            // Here goes what should happen when the Value of our OutlinedTextField changes, this is an anonymous function means a function with no name
            inputValue = it         // onValueChange return the user input in a variable 'it' of type string which we are reassigning here to inputValue
            convertUnits()
            },
            label = {Text(text = "Enter Value")}    //Text to be displayed inside the OutlinedTextField
            )

        Spacer(modifier = Modifier.height(16.dp))   //like here

        Row {  // Here all the UI elements will be stacked next to each other
//            val context = LocalContext.current      // In order to create a toast we need to have the context in which the toast is displayed, LocalContext means the toast should run in the app only
//            Button(onClick = {Toast.makeText(context,"Thanks for clicking",Toast.LENGTH_LONG).show()}) {    //We need to show() a toast after its creation
//                Text(text = "Click Me")
//            }
            // Input Box
            Box {   //This is needed to create a drop down menu, as we want everything in the same context be it button for opening the drop down menu and the drop down menu itself
                // Input Unit Button
                Button(onClick = { iExpanded = true  }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")    //Adding the arrow down icon using this, contentDescription means what the icon means this is used in accessibility
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {   //This is used to create a drop down menu, expanded means that if the menu will be opened by default or not and onDismissRequest means what should happen when the menu closes
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                        inputUnit = "Centimeters"
                        iExpanded = false
                        iConversionFactor.doubleValue = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        inputUnit = "Meters"
                        iExpanded = false
                        iConversionFactor.doubleValue = 1.00
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        inputUnit = "Feet"
                        iExpanded = false
                        iConversionFactor.doubleValue = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        inputUnit = "Millimeters"
                        iExpanded = false
                        iConversionFactor.doubleValue = 0.001
                        convertUnits()
                    })
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Output Box
            Box {   //This is needed to create a drop down menu
                // Output Unit Button
                Button(onClick = { oExpanded = true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")    //Adding the arrow down icon using this, contentDescription means what the icon means this is used in accessibility
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                        outputUnit = "Centimeters"
                        oExpanded = false
                        oConversionFactor.doubleValue = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        outputUnit = "Meters"
                        oExpanded = false
                        oConversionFactor.doubleValue = 1.00
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        outputUnit = "Feet"
                        oExpanded = false
                        oConversionFactor.doubleValue = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        outputUnit = "Millimeters"
                        oExpanded = false
                        oConversionFactor.doubleValue = 0.001
                        convertUnits()
                    })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))   // like here

        // Result Text
        Text("Result: $outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)        //Used to preview the app without running it
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}