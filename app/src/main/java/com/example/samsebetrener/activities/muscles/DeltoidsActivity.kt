package com.example.samsebetrener.activities.muscles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samsebetrener.R
import com.example.samsebetrener.adapter.ItemsVideoAdapter
import com.example.samsebetrener.models.ItemVideo
import com.example.samsebetrener.utils.initialActivity

class DeltoidsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_deltoids, R.id.main)

        val exerciseDeltoidsList: RecyclerView = findViewById(R.id.exercise_list_deltoids)
        val exercises = arrayListOf<ItemVideo>()

        exercises.add(ItemVideo(1, "military_press", "Армейский жим"))
        exercises.add(ItemVideo(2, "lateral_raises", "Махи"))
        exercises.add(ItemVideo(3, "dumbbell_press", "Жим гантелями сидя"))
        exercises.add(ItemVideo(4, "barbell_upright_row", "Подъем штанги к подбородку"))
        exercises.add(ItemVideo(5, "standing_dumbbell_press", "Жим гантелями стоя"))

        exerciseDeltoidsList.layoutManager = LinearLayoutManager(this)
        exerciseDeltoidsList.adapter = ItemsVideoAdapter(exercises, this)
    }
}