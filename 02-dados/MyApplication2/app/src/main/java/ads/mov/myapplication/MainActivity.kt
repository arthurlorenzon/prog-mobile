package ads.mov.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ads.mov.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun Dados(modifier: Modifier = Modifier) {
// Cria um estado reativo inteiro com valor inicial 1
// O operador 'by' em Kotlin é utilizado para delegação de propriedades
// 'face' é uma propriedade delegada a um objeto criado por 'remember { mutableStateOf(1) }'.
// Isso significa que 'face' irá armazenar um estado mutável que persiste durante recomposições do Composable
    var face by rememberSaveable { mutableStateOf(0) }
    var face2 by rememberSaveable { mutableStateOf(0) }
    var mensagem by rememberSaveable { mutableStateOf("") }
    var ponto by rememberSaveable { mutableStateOf(0) }
    var fimDeJogo by rememberSaveable { mutableStateOf(true) }

    if (ponto == 0){
        ponto = face + face2
        mensagem = when (ponto) {
            7 -> "Venceu"
            11 -> "Venceu"
            2 -> "Perdeu"
            3 -> "Perdeu"
            12 -> "Perdeu"
            else -> "Seu objetivo é $ponto"
        }
    } else {
        mensagem = when (face + face2) {
            ponto -> "Venceu"
            7 -> "Perdeu"
            else -> "Seu objetivo é $ponto"
        }
    }
    if (mensagem == "Venceu" || mensagem == "Perdeu"){
        fimDeJogo = true
    }
    val imagem = when (face) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imagem2 = when (face2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxSize(),
    ){
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (fimDeJogo){
                Column() {
                    if (mensagem == "Venceu" && mensagem == "Perdeu") {
                        Text(text = "$mensagem")
                    }
                    Button(
                        onClick = {fimDeJogo = false}
                    ) { Text(text = "Começar jogo")}

                }

            } else {
                Row(

                ) {
                    Image(
                        painter = painterResource(imagem),
                        contentDescription = face.toString()
                    )
                    Image(
                        painter = painterResource(imagem2),
                        contentDescription = face.toString()
                    )
                }

                Button(onClick = {
                    face = (1..6).random()
                    face2 = (1..6).random()

                }) {
                    Text("Jogar", fontSize = 24.sp)
                }
                Text(text = "$mensagem")
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun JogoDeDadosPrev() {
    Dados()
}