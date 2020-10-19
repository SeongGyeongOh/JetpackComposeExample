package com.osg.jetpackcomposeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.osg.jetpackcomposeexample.ui.typography
import dev.chrisbanes.accompanist.coil.CoilImage
import java.lang.Exception

class LayoutTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
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

    Thread.sleep(2000)

    Log.i("point2", "before lazy")
    LazyColumnFor(items = items) {item->
        Row(Modifier.padding(8.dp)){

            CoilImage(
                    data = "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg",
                    modifier = Modifier.height(100.dp)
                            .width(100.dp)
                            .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
            )
            Column(Modifier.padding(horizontal = 8.dp)
                    .fillMaxSize()
                    .height(100.dp)
                    .border(1.dp, color= Color.DarkGray, shape= RoundedCornerShape(4.dp)),
                    verticalArrangement = Arrangement.SpaceBetween) {

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