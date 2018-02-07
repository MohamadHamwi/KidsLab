package com.codebox.kidslab.CompleteWordGame

import com.codebox.kidslab.R
import java.util.*

/**
 * Created by Abed on 10/18/2017.
 */
class CompleteGameData() {

    fun loadData() :MutableList<CompleteWordDataModel>{
        val dataArray = ArrayList<CompleteWordDataModel>()
        dataArray.add(CompleteWordDataModel(R.drawable.candy, "andy", 'C', 'M', 'N', 'C'))
        dataArray.add(CompleteWordDataModel(R.drawable.suns, "un", 'U', 'M', 'S', 'S'))
        dataArray.add(CompleteWordDataModel(R.drawable.stars, "tar", 'G', 'S','R' , 'S'))

        return dataArray
    }
}
