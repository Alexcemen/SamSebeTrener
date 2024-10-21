package com.example.samsebetrener.presenters.musclesPresenters

import android.content.Context
import com.example.samsebetrener.activities.muscles.DeltoidsActivity
import com.example.samsebetrener.models.ItemVideo

class DeltoidsPresenter(private val context: Context) : MusclesPresenter(context) {
    //презенторы (DeltoidsPresenter, BicepsPresenter, PectoralisPresenter) наследуются от
    //общего MusclesPresenter, в котором хранятся списки упражнений
    //каждый презентор берет соответсвующий список и передает его в соответсвующий активити
    override fun getExercisesList(): List<ItemVideo> {
        return deltoidsExercisesList
    }
}