package com.osg.jetpackcomposeexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.jetpackcomposeexample.ui.JetpackComposeExampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainComponent()
                }
            }
        }
    }
}

@Composable
fun MainComponent() {
    val image= imageResource(id = R.drawable.header)
    MaterialTheme() {
        Column( modifier = Modifier.padding(12.dp)) {
            val imageModifier=Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape= RoundedCornerShape(4.dp))
            Image(image, imageModifier, contentScale = ContentScale.Crop)
            Text(text = "Hello!")
//            SecondComponent()
        }
    }
}

//@Composable
//fun SecondComponent(){
//    Text("good bye")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExampleTheme {
        MainComponent()
    }
}