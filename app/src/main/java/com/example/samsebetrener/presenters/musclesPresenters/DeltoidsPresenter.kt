package com.example.samsebetrener.presenters.musclesPresenters

import android.content.Context
import com.example.samsebetrener.R
import com.example.samsebetrener.activities.muscles.DeltoidsActivity
import com.example.samsebetrener.models.ItemVideo

class DeltoidsPresenter(private val resourceHelper: ResourceHelper) {
    fun getExercisesList(): List<ItemVideo> {
        return arrayListOf(
            ItemVideo(1, "military_press", resourceHelper.getString(R.string.militaryPress)),
            ItemVideo(2, "lateral_raises", resourceHelper.getString(R.string.lateralRaises)),
            ItemVideo(3, "dumbbell_press", resourceHelper.getString(R.string.dumbbellPress)),
            ItemVideo(4, "barbell_upright_row", resourceHelper.getString(R.string.barbellUprightRow)),
            ItemVideo(5, "standing_dumbbell_press", resourceHelper.getString(R.string.standingDumbbellPress))
        )
    }
}