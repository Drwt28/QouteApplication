package com.example.qouteapplication.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qouteapplication.DataRepository.DataRepository
import com.example.qouteapplication.R


class QuoteViewModel : ViewModel(){
    var dataRespository  = DataRepository()


    var loading by mutableStateOf(false)


    var quoteList by mutableStateOf(ArrayList<String>())



    fun changeLoading(){
        loading  = !loading;
    }

   suspend fun  getQuotes(){
       changeLoading()
       quoteList =  dataRespository.getData();
       changeLoading()
    }





}