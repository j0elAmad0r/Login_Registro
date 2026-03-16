package com.example.myapplication
import androidx.compose.material3.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource

    @Preview(showBackground = true)
    @Composable
    fun RegisterPreview() {
        Registro(onLoginClick = {})
    }

    @Composable
    fun Registro(modifier: Modifier = Modifier, onLoginClick: () -> Unit) {

        Box(
            modifier = modifier
                .fillMaxSize()

                // fondo degradado
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF6EA8FF),
                            Color(0xFF3B82F6)
                        )
                    )
                )
                .padding(24.dp),

            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(28.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Variables de formulario
                    var nombre by remember { mutableStateOf("") }
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var confirmarPassword by remember { mutableStateOf("") }
                    // Validacion de campos correctos
                    val formularioValido =
                        nombre.isNotBlank() &&
                                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                                password.isNotBlank() &&
                                password == confirmarPassword

                    Box(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.jw),
                            contentDescription = "logo"
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Crear cuenta",
                        fontSize = 20.sp,
                        color = Color(0xFF3B82F6)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // NAME
                    Text(
                        text = "Nombre",
                        fontSize = 14.sp,
                        color = Color(0xFF3B82F6),
                        modifier = Modifier.align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    TextField(
                        value = nombre,
                        onValueChange = {texto ->
                            val regex = Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$")
                            if (regex.matches(texto)) {
                                nombre = texto
                            }
                        },
                        placeholder = { Text("Tu nombre") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // EMAIL
                    Text(
                        text = "Email",
                        fontSize = 14.sp,
                        color = Color(0xFF3B82F6),
                        modifier = Modifier.align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    TextField(
                        value = email,
                        onValueChange = { texto ->

                            email = texto

                        },
                        placeholder = { Text("email@gmail.com") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    TextField(
                        value = email,
                        onValueChange = { texto ->

                            email = texto

                        },
                        placeholder = { Text("email@gmail.com") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // PASSWORD
                    Text(
                        text = "Password",
                        fontSize = 14.sp,
                        color = Color(0xFF3B82F6),
                        modifier = Modifier.align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("••••••••") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    TextField(
                        value = confirmarPassword,
                        onValueChange = { confirmarPassword = it },
                        placeholder = { Text("••••••••") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {"Formulario correcto"},
                        enabled = formularioValido,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),

                        shape = RoundedCornerShape(50.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2563EB)
                        )
                    )
                    {
                        Text(
                            text = "Crear cuenta",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "¿Ya tienes cuenta? Dirigetew al LogIn",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        // Regreso a login
                        modifier = Modifier.clickable {
                            onLoginClick()
                        }
                    )

                }
            }
        }
    }