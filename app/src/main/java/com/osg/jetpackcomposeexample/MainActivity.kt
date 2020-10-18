package com.osg.jetpackcomposeexample

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.annotation.Px
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.geometry.Size.Companion.Zero
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.asImageAsset
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Constraints.Companion.Infinity
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.tooling.preview.Preview
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.CachePolicy
import coil.size.Scale
import coil.target.Target
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Preview
@Composable
fun aa(){
    Text(text = "aa")
}
