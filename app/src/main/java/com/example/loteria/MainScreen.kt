package com.example.loteria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun StartScreen(navController: NavController) {

    // Colocamos la imagen como fondo en toda la pantalla
    Image(
        painter = painterResource(id = R.drawable.fondo2),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título en la parte superior
        Text(
            text = "Lotería Mexicana",
            fontSize = 30.sp,
            color = Color.Red,
            style = MaterialTheme.typography.bodyLarge, // estilo del texto
            modifier = Modifier.padding(bottom = 26.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Imagen de logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Lotería Mexicana",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para iniciar el juego
        Button(onClick = { navController.navigate("game") }) {
            Text(text = "Iniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(navController = rememberNavController())
}
