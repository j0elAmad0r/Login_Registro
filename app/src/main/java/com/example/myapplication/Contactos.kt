package com.example.myapplication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

// Vista previa
@Preview(showBackground = true)
@Composable
fun PreviewContactos() {
    VistaContactos()
}

// Modelo para representar contacto
data class Contacto(
    val nombre: String,
    val telefono: String
)

@Composable
fun VistaContactos(modifier: Modifier = Modifier) {
    // guarda lo que el usuario escribe
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // lista de contactos dinamica
    val contactos = remember {
        mutableStateListOf(
            Contacto("Joel", "6122048809"),
            Contacto("Jose", "6122048809"),
            Contacto("Caro", "6122048809")
        )
    }
    // estructura basica
    Scaffold(
        bottomBar = {
            // barra de navegacion inferior
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Contactos") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Call, null) },
                    label = { Text("Recientes") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Star, null) },
                    label = { Text("Favoritos") }
                )
            }
        }
    ) { padding ->
        // contenedor principal
        Column(
            modifier = modifier
                .fillMaxSize() // pantalla completa
                .padding(16.dp),
            verticalArrangement = Arrangement.Center // centrado vertical
        ) { // ventana del contenido
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .heightIn(min = 555.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    // HEADER
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                        Text(
                            "Mis Contactos",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Icon(Icons.Default.AccountCircle, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // inputs
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") },
                        placeholder = { Text("Ej: Joel Amador") },
                        leadingIcon = { Icon(Icons.Default.Person, null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = telefono,
                        onValueChange = { telefono = it },
                        label = { Text("Telefono") },
                        leadingIcon = { Icon(Icons.Default.Call, null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button( // btn para agregar contacto
                        onClick = { // validacion
                            if (nombre.isNotBlank() && telefono.isNotBlank()) {
                                contactos.add(Contacto(nombre, telefono))
                                nombre = ""
                                telefono = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2962FF)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Agregar contacto")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn { // lista de contactos
                        items(contactos) { contacto ->
                            ContactosItem(contacto)
                        }

                    }
                }
            }
        }
    }
}
// contacto individual
@Composable
fun ContactosItem(contacto: Contacto) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // icono del contacto
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFE3F2FD), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
        }

        Spacer(modifier = Modifier.width(12.dp))
        // info del contacto
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = contacto.nombre,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = contacto.telefono,
                color = Color.Gray
            )
        }
    }
}