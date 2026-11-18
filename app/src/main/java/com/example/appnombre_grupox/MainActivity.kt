package com.example.appnombre_grupox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.screens.PostScreen
import ui.screens.LoginScreen
import viewmodel.PostViewModel
import ui.screens.CameraScreen
import ui.screens.ProfileScreen
import ui.screens.GpsScreen
import ui.screens.CatalogoScreen
import data.model.Usuario



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {


            var sesionIniciada by remember {
                mutableStateOf(false)
            }


            var mostrarCamara by remember {
                mutableStateOf(false)
            }


            var mostrarPerfil by remember {
                mutableStateOf(false)
            }

            var mostrarGps by remember {
                mutableStateOf(false)
            }

            var mostrarCatalogo by remember {
                mutableStateOf(false)
            }

            var mostrarPedidos by remember {
                mutableStateOf(false)
            }

            var usuarioActual by remember {
                mutableStateOf<Usuario?>(null)
            }






            if (!sesionIniciada) {

                // Pantalla de inicio de sesión
                LoginScreen(
                    onLoginSuccess = { usuario ->
                        usuarioActual = usuario
                        sesionIniciada = true
                        mostrarCamara = false
                        mostrarPerfil = false
                        mostrarGps = false
                        mostrarCatalogo = false
                        mostrarPedidos = false
                    }
                )


            } else if (mostrarCamara) {

                CameraScreen(
                    onVolver = {
                        mostrarCamara = false
                    }
                )

            } else if (mostrarPerfil) {

                ProfileScreen(
                    onVolver = {
                        mostrarPerfil = false
                    }
                )

            } else if (mostrarGps) {

                GpsScreen(
                    onVolver = {
                        mostrarGps = false
                    }
                )

            } else if (mostrarCatalogo) {

                CatalogoScreen(
                    onVolver = {
                        mostrarCatalogo = false
                    }
                )

            } else {





                // Pantalla de publicaciones
                val postViewModel: PostViewModel = viewModel()


                PostScreen(
                    viewModel = postViewModel,

                    onCerrarSesion = {
                        usuarioActual = null
                        sesionIniciada = false
                        mostrarCamara = false
                        mostrarPerfil = false
                        mostrarGps = false
                        mostrarCatalogo = false
                        mostrarPedidos = false
                    },

                    onAbrirCamara = {
                        mostrarPerfil = false
                        mostrarCamara = true
                    },

                    onAbrirPerfil = {
                        mostrarCamara = false
                        mostrarPerfil = true
                    },


                    onAbrirGps = {
                        mostrarCamara = false
                        mostrarPerfil = false
                        mostrarGps = true
                    },

                    onAbrirCatalogo = {
                        mostrarCamara = false
                        mostrarPerfil = false
                        mostrarGps = false
                        mostrarCatalogo = true
                    },

                    onAbrirPedidos = {
                        mostrarPedidos = true
                    }



                )



            }


        }
    }
}
