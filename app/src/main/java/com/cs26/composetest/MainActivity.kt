package com.cs26.composetest

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cs26.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SimpleWidgetColumn()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleWidgetColumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        val context = LocalContext.current
        val bitmap:ImageBitmap = ImageBitmap.imageResource(id = R.drawable.share_icon)
        Text(
            modifier = Modifier.align(Alignment.End),
            text = "This is Text",
            color = Color.Blue,
            fontSize = 26.sp
        )
        Button(onClick = {
            Toast.makeText(context,"Clicked Button",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "This is Button", color = Color.White, fontSize = 26.sp)
        }
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Type something here")
            },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
        )
        Image(painter = painterResource(id = R.drawable.share_icon), contentDescription = "A share image")
        Image(bitmap = bitmap, contentDescription = "A share image")
//        AsyncImage(model = "https://img-blog.csdnimg.cn/20200401094829557.jpg", contentDescription = "First line of code")
        CircularProgressIndicator(color = Color.Green, strokeWidth = 6.dp)
        LinearProgressIndicator(color = Color.Blue, trackColor = Color.Gray)
    }
}