package com.example.loteria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import kotlin.random.Random

@Composable
fun PlayScreen(navController: NavController) {
    // Lista de cartas (referencia a las imágenes de la carpeta drawable)
    val cardImages = listOf(
        R.drawable.elarpa, R.drawable.elcazo, R.drawable.elpino, R.drawable.labota, R.drawable.elalacran,
        R.drawable.elapache, R.drawable.elarbol, R.drawable.elbandolon, R.drawable.elbarril,
        R.drawable.elborracho, R.drawable.elcamaron, R.drawable.elcantarito, R.drawable.elcatrin, R.drawable.elcorazon,
        R.drawable.elcotorro, R.drawable.eldiablito, R.drawable.elgallo, R.drawable.elgorrito, R.drawable.elmelon,
        R.drawable.elmundo, R.drawable.elmusico, R.drawable.elnegrito, R.drawable.elnopal, R.drawable.elpajaro,
        R.drawable.elparaguas, R.drawable.elpescado, R.drawable.elsol, R.drawable.elsoldado, R.drawable.eltambor,
        R.drawable.elvaliente, R.drawable.elvenado, R.drawable.elvioloncello, R.drawable.laarana, R.drawable.labandera,
        R.drawable.labotella, R.drawable.lacalavera, R.drawable.lacampana, R.drawable.lachalupa, R.drawable.lacorona,
        R.drawable.ladama, R.drawable.laescalera, R.drawable.laestrella, R.drawable.lagarza, R.drawable.laluna,
        R.drawable.lamano, R.drawable.lamaceta, R.drawable.lamuerte, R.drawable.lapalma, R.drawable.lapera,
        R.drawable.larana, R.drawable.larosa, R.drawable.lasandia, R.drawable.lasirena, R.drawable.lasjaras

    )

    // Estado para mantener la carta actual
    var currentCard by remember { mutableStateOf(cardImages.random()) }

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
            text = "Juego de Lotería",
            fontSize = 30.sp,
            color = Color.Red,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        // Mostrar la carta actual
        Image(
            painter = painterResource(id = currentCard),
            contentDescription = "Carta de Lotería Mexicana",
            modifier = Modifier.size(320.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para mostrar una nueva carta
        Button(onClick = { currentCard = cardImages.random() }) {
            Text(text = "Siguiente carta")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Botón para terminar el juego y volver a la pantalla de inicio
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Terminar Juego")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayScreenPreview() {
    PlayScreen(navController = rememberNavController())
}
