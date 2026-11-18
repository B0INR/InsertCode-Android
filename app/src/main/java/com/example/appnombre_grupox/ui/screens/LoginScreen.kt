package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Usuario
import data.model.UsuariosDemo

@Composable
fun LoginScreen(
    onLoginSuccess: (Usuario) -> Unit
) {

    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var mostrarContrasena by remember { mutableStateOf(false) }
    var mensajeError by remember { mutableStateOf("") }

    val fondo = Color(0xFF0B1020)
    val campo = Color(0xFF111B2E)
    val azul = Color(0xFF3F51B5)
    val textoSecundario = Color(0xFF9BAFCE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "🔒 Acceso Seguro",
            color = Color(0xFF25D6A2),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Bienvenido de vuelta",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ingresa a tu turno de monitoreo",
            color = textoSecundario,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "CORREO ELECTRÓNICO",
            color = Color(0xFFBBCFF3),
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                mensajeError = ""
            },
            label = { Text("Correo electrónico") },
            leadingIcon = { Text("✉️") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = campo,
                unfocusedContainerColor = campo,
                focusedBorderColor = azul,
                unfocusedBorderColor = Color(0xFF28344B),
                focusedLabelColor = textoSecundario,
                unfocusedLabelColor = textoSecundario
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "CONTRASEÑA",
            color = Color(0xFFBBCFF3),
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = {
                contrasena = it
                mensajeError = ""
            },
            label = { Text("Contraseña") },
            leadingIcon = { Text("🔒") },
            trailingIcon = {
                TextButton(
                    onClick = {
                        mostrarContrasena = !mostrarContrasena
                    }
                ) {
                    Text(
                        if (mostrarContrasena) "Ocultar"
                        else "Ver",
                        color = Color(0xFF60A5FA)
                    )
                }
            },
            visualTransformation =
                if (mostrarContrasena)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = campo,
                unfocusedContainerColor = campo,
                focusedBorderColor = azul,
                unfocusedBorderColor = Color(0xFF28344B),
                focusedLabelColor = textoSecundario,
                unfocusedLabelColor = textoSecundario
            )
        )

        if (mensajeError.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = mensajeError,
                color = Color(0xFFFF6B6B),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {

                val usuario = UsuariosDemo.validarLogin(
                    correo = correo,
                    contrasena = contrasena
                )

                if (usuario != null) {
                    mensajeError = ""
                    onLoginSuccess(usuario)
                } else {
                    mensajeError = "Correo o contraseña incorrectos"
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = azul
            )
        ) {
            Text(
                text = "Ingresar al sistema →",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Tus permisos se cargarán según tu perfil",
            color = textoSecundario,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
