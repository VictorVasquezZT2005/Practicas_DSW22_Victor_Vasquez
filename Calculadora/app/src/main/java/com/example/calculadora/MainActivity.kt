package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Usamos el tema Material3 por defecto
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraUI(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculadoraUI(modifier: Modifier = Modifier) {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var numero3 by remember { mutableStateOf("") }
    var operacion by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numero3,
            onValueChange = { numero3 = it },
            label = { Text("Número 3") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = operacion,
            onValueChange = { operacion = it },
            label = { Text("Operación (+, -, *, /)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull()
                val n2 = numero2.toDoubleOrNull()
                val n3 = numero3.toDoubleOrNull()

                resultado = if (n1 != null && n2 != null && n3 != null) {
                    when (operacion.trim()) {
                        "+" -> (n1 + n2 + n3).toString()
                        "-" -> (n1 - n2 - n3).toString()
                        "*" -> (n1 * n2 * n3).toString()
                        "/" -> if (n2 != 0.0 && n3 != 0.0) (n1 / n2 / n3).toString() else "Error: División por 0"
                        else -> "Operación inválida"
                    }
                } else {
                    "Números inválidos"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Text(
            text = "Resultado: $resultado",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
