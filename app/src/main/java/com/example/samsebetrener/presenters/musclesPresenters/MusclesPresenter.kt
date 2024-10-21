package com.example.samsebetrener.presenters.musclesPresenters

import android.content.Context
import com.example.samsebetrener.R
import com.example.samsebetrener.models.ItemVideo

abstract class MusclesPresenter(private val context: Context) {

    //в этом классе будут храниться упражнения для разных мышечных групп

    val deltoidsExercisesList: ArrayList<ItemVideo> = arrayListOf(
        ItemVideo(1, "military_press", context.getString(R.string.militaryPress)),
        ItemVideo(2, "lateral_raises", context.getString(R.string.lateralRaises)),
        ItemVideo(3, "dumbbell_press", context.getString(R.string.dumbbellPress)),
        ItemVideo(4, "barbell_upright_row", context.getString(R.string.barbellUprightRow)),
        ItemVideo(5, "standing_dumbbell_press", context.getString(R.string.standingDumbbellPress))
    )

//    val bicepsExercisesList: ArrayList<ItemVideo> = arrayListOf(
//        упражнение 1
//        упражнение 2
//        упражнение 3
//        упражнение 4
//    )

//     val pectoralisExercisesList: ArrayList<ItemVideo> = arrayListOf(
//        упражнение 1
//        упражнение 2
//        упражнение 3
//        упражнение 4
//    )


    abstract fun getExercisesList(): List<ItemVideo>
}