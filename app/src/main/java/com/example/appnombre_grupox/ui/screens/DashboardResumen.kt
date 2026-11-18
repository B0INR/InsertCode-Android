package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val fondoTarjeta = Color(0xFF111A2D)
private val azul = Color(0xFF2563EB)
private val verde = Color(0xFF10B981)
private val amarillo = Color(0xFFF59E0B)

@Composable
fun DashboardResumen(
    onNuevoPedido: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Panel Comercial & Operacional",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Indicadores clave de ventas y entregas",
            color = Color(0xFF94A3B8),
            fontSize = 13.sp
        )

        Button(
            onClick = onNuevoPedido,
            colors = ButtonDefaults.buttonColors(
                containerColor = azul
            )
        ) {
            Text("+ Nuevo Pedido")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TarjetaIndicador(
                    "VENTAS TOTALES",
                    "$0",
                    verde
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                TarjetaIndicador(
                    "PENDIENTES",
                    "1",
                    amarillo
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TarjetaIndicador(
                    "EN RUTA",
                    "1",
                    Color(0xFF60A5FA)
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                TarjetaIndicador(
                    "ENTREGADOS",
                    "1",
                    verde
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = fondoTarjeta
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Estado de Pedidos en Terreno",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(amarillo)
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color(0xFF3B82F6))
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(verde)
                    )
                }

                Text(
                    text = "🟡 Pendientes (1)   🔵 En ruta (1)",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )

                Text(
                    text = "🟢 Entregados (1)",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun TarjetaIndicador(
    titulo: String,
    valor: String,
    color: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = fondoTarjeta
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = titulo,
                color = Color(0xFF94A3B8),
                fontSize = 11.sp
            )

            Text(
                text = valor,
                color = color,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
