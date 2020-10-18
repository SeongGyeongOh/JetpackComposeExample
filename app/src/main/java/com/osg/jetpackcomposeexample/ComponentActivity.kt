package com.osg.jetpackcomposeexample

import android.content.Context
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyCharacterMap.load
import android.view.PointerIcon.load
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.core.view.PointerIconCompat.load
import androidx.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.System.load
import java.lang.reflect.Type
import java.util.ServiceLoader.load

class ComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            secondComponent()
            callData()
        }
    }
}


@Composable
fun secondComponent(){
    Column {

        TopAppBar(title = {Text(text="coordinate layout을 사용해 보자\n여기는 coordinate layout이 될 예정임")})

        val datas=ArrayList<ClassElement>()

//        datas.add(Test("피아노 연습책", "피아노", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
//        datas.add(Test("ㅁㅁ 연습책", "ㅁㅁ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
//        datas.add(Test("ㄴㄴ 연습책", "ㄴㄴ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
//        datas.add(Test("ㅇㅇ 연습책", "ㅇㅇ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
//        datas.add(Test("ㄹㄹ 연습책", "ㄹㄹ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
//        datas.add(Test("ㅎㅎ 연습책", "ㅎㅎ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))

        LazyColumnFor(datas) {item->
            Row() {
                    imageComponent()
                Column {
                    Text("${item.title}")
                    Text("${item.category}")
                    Text("${item.price} 원")
                }
            }
        }
    }
}

@Composable
fun imageComponent(){
    val image= imageResource(id = R.drawable.header)
    val imageModifier= Modifier
        .preferredHeight(80.dp)
        .preferredWidth(100.dp)
    Image(image, imageModifier)
}

@Composable
fun callData(){
    val retrofit=RetrofitHelper().getRetrofit()
    val service=retrofit.create(RetrofitService::class.java)
    var call=service.getData()

    call.enqueue(object : Callback<ArrayList<ClassElement>> {
        override fun onResponse(call: Call<ArrayList<ClassElement>>,response: Response<ArrayList<ClassElement>>) {
            if(response.isSuccessful){
                val items  = response.body()
            }
        }

        override fun onFailure(call: Call<ArrayList<ClassElement>>, t: Throwable) {
            Log.e("확인", "" + t.message)
        }

    })
}




@Preview
@Composable
fun defaultPreview(){
    secondComponent()
}

class Test {
    constructor(title: String?, category: String?, price: Long?, thumbURL: String?) {
        this.title = title
        this.category = category
        this.price = price
        this.thumbURL = thumbURL
    }

    var title:String?=null
    var category:String?=null
    var price:Long?=null
    var thumbURL:String?=null
}
