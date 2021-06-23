package com.example.qouteapplication.DataRepository

import kotlinx.coroutines.delay

class DataRepository {

    //api call using retrofit

    //local sql querry using room

    suspend fun getData() : ArrayList<String>{


        //simulate the real process of getting data

        var tempList = arrayListOf<String>("Hello","First","Second","Third");

        delay(1000)

        return tempList

    }
}