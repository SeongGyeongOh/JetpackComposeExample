package com.osg.jetpackcomposeexample

import android.graphics.Paint
import android.os.Bundle
import android.provider.Contacts.PresenceColumns.IDLE
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.jetpackcomposeexample.ui.JetpackComposeExampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Title()
                LayoutTest()
            }
        }
    }
}

@Composable
fun Title(){
    Text(
        text = "Jetpack Compose 연습입니다",
        style = MaterialTheme.typography.h6,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = Color.Blue,
        )
}
