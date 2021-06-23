package com.example.qouteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultCameraDistance
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.qouteapplication.ViewModel.QuoteViewModel


import com.example.qouteapplication.ui.theme.QouteApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QouteApplicationTheme {

                // A surface container using the 'background' color from the theme


                val quoteViewModel by viewModels<QuoteViewModel>()

                Surface(color = MaterialTheme.colors.background) {
                    QuoteHomeScreen(quoteViewModel)
                }
            }
        }
    }
}


@Composable
fun QuoteHomeScreen(model : QuoteViewModel) {

    val loading =  model.loading;

    val dataList =  model.quoteList


    var scope =  rememberCoroutineScope()



    Column(verticalArrangement = Arrangement.Center) {



        TextButton(onClick = {


            scope.launch {

                model.getQuotes();
            }

        }) {
            Text("Get Quotes")
        }


        if(dataList.size==0||loading)
        {
            CircularProgressIndicator()
        }
        else{
            for (data in dataList)
                Text(data)
        }
    }




}









