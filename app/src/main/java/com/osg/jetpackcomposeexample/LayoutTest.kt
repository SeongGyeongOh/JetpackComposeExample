package com.osg.jetpackcomposeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.jetpackcomposeexample.ui.JetpackComposeExampleTheme
import com.osg.jetpackcomposeexample.ui.typography
import dev.chrisbanes.accompanist.coil.CoilImage
import java.lang.Exception

import androidx.compose.ui.unit.lerp
import kotlin.math.max
import kotlin.math.min

import androidx.compose.ui.measureBlocksOf
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.Layout
import androidx.compose.ui.util.lerp
import androidx.compose.ui.layout
import androidx.compose.ui.platform.DensityAmbient

@Composable
fun LayoutTest(){
    Column{
        Header()
        listComponent2()
    }
}

@Composable
fun listComponent2(){
    val retrofit=RetrofitHelper().getRetrofit()
    val service=retrofit.create(RetrofitService::class.java)
    var call=service.getData()
    var items= ArrayList<ClassElement>()

    Thread{
        run {
            try{
                val response=call.execute()
                items=response.body()!!
                Log.i("point", "${items}")
            }catch (e: Exception){
                Log.e("point-1", "retrofit failed")
            }
        }
    }.start()

    Thread.sleep(1000)

    Log.i("point2", "before lazy")
    LazyColumnFor(items = items) {item->
        Row(Modifier.padding(8.dp)){

            CoilImage(
                    data = "${item.bannerImages?.get(0)?.thumbUrl}",
                    modifier = Modifier.height(100.dp)
                            .width(100.dp)
                            .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(horizontal = 8.dp)
                    .fillMaxSize()
                    .height(100.dp)
                    .border(1.dp, color= Color.DarkGray, shape= RoundedCornerShape(4.dp)),
                    verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${item.title}",
                        style = typography.body1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.preferredHeight(2.dp))
                Text(text = "${item.category}",
                        modifier = Modifier.align(Alignment.End)
                                .padding(4.dp),
                        style = typography.caption)
                Spacer(modifier = Modifier.preferredHeight(1.dp))
                Text(text = "${item.price}",
                        modifier = Modifier.padding(4.dp))
                Spacer(modifier = Modifier.preferredHeight(1.dp))
            }

        }
    }
}

@Composable
fun Header() {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        CoilImage(
            data = "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg",
            modifier = Modifier.height(100.dp)
                .width(100.dp)
                .clip(shape = RoundedCornerShape(50.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .height(100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Custom layout", fontWeight = FontWeight.Bold)
            Text("need to add animation!!", style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    JetpackComposeExampleTheme{
//        Header()
    }
}