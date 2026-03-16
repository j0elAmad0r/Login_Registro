package com.example.myapplication
import androidx.compose.material3.Card
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // estado que controla que pantalla mostrar
                var mostrarLogin by remember { mutableStateOf(true) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    if (mostrarLogin) {
                        Login(
                            modifier = Modifier.padding(innerPadding),

                            // cuando el usuario toca registrarse
                            onRegisterClick = {
                                mostrarLogin = false
                            }
                        )

                    } else {

                        Registro(
                            modifier = Modifier.padding(innerPadding),

                            // cuando el usuario toca volver al login
                            onLoginClick = {
                                mostrarLogin = true
                            }
                        )

                    }

                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier, onRegisterClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            // usar toda la pantalla
            .fillMaxSize()

            // Fondo con degradado de inicio a fin
            .background(
                // para el degradadi
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

            // Bordes redondeados
            shape = RoundedCornerShape(24.dp),
            //
            elevation = CardDefaults.cardElevation(10.dp),

            /* colors = CardDefaults.cardColors(
                containerColor = Color.White
            */
        ) {

            Column(
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                    text = "Bienvenido de regreso",
                    fontSize = 20.sp,
                    color = Color(0xFF3B82F6)
                )
                // espacio entre componentes
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = Color(0xFF3B82F6),
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("email@gmail.com") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

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

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Olvidaste tu contraseña?",
                    fontSize = 13.sp,
                    color = Color(0xFF3B82F6),
                    modifier = Modifier.align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        println("Email: $email")
                        println("Password: $password")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Text(
                        text = "Login",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "¿No tienes cuenta? Registrate",
                    modifier = Modifier.clickable {
                        onRegisterClick()
                    },
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}