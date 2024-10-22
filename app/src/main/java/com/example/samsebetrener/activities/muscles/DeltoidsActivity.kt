package com.example.samsebetrener.activities.muscles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samsebetrener.R
import com.example.samsebetrener.adapter.ItemsVideoAdapter
import com.example.samsebetrener.models.ItemVideo
import com.example.samsebetrener.presenters.musclesPresenters.DeltoidsPresenter
import com.example.samsebetrener.presenters.musclesPresenters.ResourceHelper
import com.example.samsebetrener.utils.initialActivity

class DeltoidsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_deltoids, R.id.main)

        val exerciseDeltoidsList: RecyclerView = findViewById(R.id.exercise_list_deltoids)
        val resourceHelper = ResourceHelper(context = this)
        val deltoidsPresenter = DeltoidsPresenter(resourceHelper = resourceHelper)
        val exercises = deltoidsPresenter.getExercisesList()
        exerciseDeltoidsList.layoutManager = LinearLayoutManager(this)
        exerciseDeltoidsList.adapter = ItemsVideoAdapter(exercises, this)
    }
}