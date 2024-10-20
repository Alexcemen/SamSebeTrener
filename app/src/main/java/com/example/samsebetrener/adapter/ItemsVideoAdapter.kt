package com.example.samsebetrener.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samsebetrener.R
import com.example.samsebetrener.models.ItemVideo

class ItemsVideoAdapter(var exercises: List<ItemVideo>, var context: Context)
    : RecyclerView.Adapter<ItemsVideoAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.exercise_image)
        val title: TextView = view.findViewById(R.id.exercise_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercises_design, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exercises.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = exercises[position].title

        var imageId = context.resources.getIdentifier(
            exercises[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)
    }

}