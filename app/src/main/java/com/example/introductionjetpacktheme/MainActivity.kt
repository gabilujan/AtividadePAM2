package com.example.introductionjetpacktheme

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introductionjetpacktheme.ui.theme.DebugButtonColors
import com.example.introductionjetpacktheme.ui.theme.ErrorButtonColors
import com.example.introductionjetpacktheme.ui.theme.InfoButtonColors
import com.example.introductionjetpacktheme.ui.theme.IntroductionJetPackThemeTheme
import com.example.introductionjetpacktheme.ui.theme.WarningButtonColors
import java.lang.RuntimeException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionJetPackThemeTheme {
               App()

            }
        }
    }
}
@Preview
@Composable

fun SimpleTextField(){
    var text by remember{ mutableStateOf("") }

    TextField(value = text, onValueChange = {}, label = { Text(text = "Nome")})
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // Logo da Etec ZL
        Image(
            painter = painterResource(id = R.drawable.etec),
            contentDescription = "Logo da Etec ZL",
            modifier = Modifier.size(120.dp)
        )
            Greeting("JetPack")
            SimpleTextField()
            ActionButton(
                text = "Menção B",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d(TAG, "Sua nota é B")
            }
            ActionButton(
                text = "Mencão MB",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "Sua nota é MB")
            }
            ActionButton(
                text = "Menção R",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.w(TAG, "Sua nota é R")
            }
            ActionButton(
                text = "Menção I",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    throw RuntimeException("Sua nota é i")
                } catch (ex: Exception) {
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}


@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Atividade de PAM 2!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
    ),
    color  =MaterialTheme.colorScheme.secondary
    )
}
@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview (){
    IntroductionJetPackThemeTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview (){
    ActionButton(text = "Cadastrar") {
    }
}
@Preview(showBackground = true, widthDp = 120)
@Composable
fun GreetingPreview (){
    IntroductionJetPackThemeTheme{
    Greeting("JetPack")
    }
}