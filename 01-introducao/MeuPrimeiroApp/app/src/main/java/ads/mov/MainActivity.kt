package ads.mov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ads.mov.ui.theme.MeuPrimeiroAppTheme
import android.content.res.Configuration
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuPrimeiroAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "ADS",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Column {
            Text(
                text = "Hello $name!",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(24.dp)
            )
            Text(text = "Teste")
        }

    }

}

//@Preview
//@Composable
//private fun GreetingPreview() {
//    MeuPrimeiroAppTheme {
//        Greeting("ADS")
//    }
//}
//
//
//@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//private fun GreetingPreviewDark() {
//    MeuPrimeiroAppTheme {
//        Greeting("ADS")
//    }
//}

@Composable
fun Imagem(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
//            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier, verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Bom dia"
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.fundo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.2f
        )


    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun ImagemPreview() {
//
//}

@Composable
fun Saudacao(nome: String, modifier: Modifier =
    Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(
                vertical = 4.dp, horizontal = 8.dp
            )
            .windowInsetsPadding(WindowInsets.statusBars)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Olá ")
            Text(text = nome)
        }
    }
    Imagem()
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SaudacaoPreview(modifier: Modifier = Modifier) {
    Surface () {
        Column {
            Saudacao("Olá Mundo", Modifier.weight(1f))
            Saudacao("Olá Compose", Modifier.weight(2f))
        }
    }
}