package com.osg.jetpackcomposeexample

import android.content.Context
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import coil.Coil
//import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class ComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            secondComponent()
//            callData()

        }
    }
}

@Composable
fun secondComponent(){
    Column {

        TopAppBar(title = {Text(text="coordinate layout을 사용해 보자\n여기는 coordinate layout이 될 예정임")})

        val retrofit=RetrofitHelper().getRetrofit()
        val service=retrofit.create(RetrofitService::class.java)
        var call=service.getData()
        var items= ArrayList<ClassElement>()


        call.enqueue(object : retrofit2.Callback<ArrayList<ClassElement>> {
            override fun onResponse(call: Call<ArrayList<ClassElement>>,response: Response<ArrayList<ClassElement>>) {
                if(response.isSuccessful){
                    var lists = response.body()
//                    if (lists != null) {
//                        for(list in lists){
//                            items.add(list)
//                        }
//                    }
                    items= lists!!
                }
            }

            override fun onFailure(call: Call<ArrayList<ClassElement>>, t: Throwable) {
                Log.e("확인", "" + t.message)
            }

        })

        LazyColumnFor(items = items) {item->
            Column() {
                Text(text = "${item.category}")
            }
        }
    }

}

@Composable
fun list(){

        val datas=ArrayList<Test>()

        datas.add(Test("바이올린 연습책", "피아노", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
        datas.add(Test("ㅁㅁ 연습책", "ㅁㅁ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
        datas.add(Test("ㄴㄴ 연습책", "ㄴㄴ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
        datas.add(Test("ㅇㅇ 연습책", "ㅇㅇ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
        datas.add(Test("ㄹㄹ 연습책", "ㄹㄹ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
        datas.add(Test("ㅎㅎ 연습책", "ㅎㅎ", 10000, "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg"))
    LazyColumnFor(datas) {item->
        Row() {
            Column {
                Text("${item.title}")
                Text("${item.category}")
                Text("${item.price} 원")
                imageComponent()
//                CoilImage("https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg")
            }
        }
    }
}

@Composable
fun imageComponent(){

    val image= imageResource(id = R.drawable.header)
    Image(image)
}




//@Composable
//fun callData(){
//    val retrofit=RetrofitHelper().getRetrofit()
//    val service=retrofit.create(RetrofitService::class.java)
//    var call=service.getData()
//
//
//    call.enqueue(object : retrofit2.Callback<ArrayList<ClassElement>> {
//        override fun onResponse(call: Call<ArrayList<ClassElement>>,response: Response<ArrayList<ClassElement>>) {
//            if(response.isSuccessful){
//                val items  = response.body()
//            }
//        }
//
//        override fun onFailure(call: Call<ArrayList<ClassElement>>, t: Throwable) {
//            Log.e("확인", "" + t.message)
//        }
//
//    })
//}
//



@Preview
@Composable
fun defaultPreview(){
    secondComponent()
//    CoilImage(data = "https://madi-1302397712.cos.ap-seoul.myqcloud.com/images/5f027fbcc9986921824aae6f_1602646108078.jpg")
//    list()
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
