package com.example.myapplication


import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        //Hello(name = "Yuri")
                        //Hello(name = null)
                        //RoundScreen()
                        //StyledButton()
                        InitialsContainer("ЮЕ")
                    }
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    Text(text = if (name != null) "Привет, $name!" else "Имя не задано")
}



//задание 2
@Preview(
    name = "Portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun HelloPreviewPortrait(){
    MyApplicationTheme {
        Hello(name = "Android")
    }
}

@Preview(
    name = "Landscape",
    showSystemUi = true,
    device = "spec:width=891dp,height=411dp"
)
@Composable
fun HelloPreviewLandscape() {
    MyApplicationTheme {
        Hello(name = "Android")
    }
}
@Preview(
    name = "Round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true"
)
@Composable
fun HelloPreviewRound() {
    MyApplicationTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        ) {
            Hello(name = "Android")
        }
    }
}
@Composable
fun RoundScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Hello(name = "Android")
        }
    }
}


//Задание 3
@Composable
fun TextVariant1() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun TextVariant3() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    )
}
@Composable
fun TextVariant2() {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TextVariantsPreview() {
    MyApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text("Вариант 1:", fontSize = 12.sp, color = Color.Gray)
            TextVariant1()

            Text("Вариант 2:", fontSize = 12.sp, color = Color.Gray)
            TextVariant2()

            Text("Вариант 3:", fontSize = 12.sp, color = Color.Gray)
            TextVariant3()
        }
    }
}
@Composable
fun StyledButton() {
    Button(

        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Нажми меня",
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}