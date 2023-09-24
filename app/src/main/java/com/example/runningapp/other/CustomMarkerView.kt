package com.example.runningapp.other

import android.app.Activity
import android.content.Context
import android.widget.TextView
import com.example.runningapp.R
import com.example.runningapp.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CustomMarkerView(
    val runs : List<Run>,
    c: Context,
    layoutId:Int
) : MarkerView(c,layoutId) {

    override fun getOffset(): MPPointF {
//        return super.getOffset()
        return MPPointF(-width/2f,-height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)

        if(e == null){
            return
        }
        val currentIdRun = e.x.toInt()
        val run = runs[currentIdRun]

        val calenar  = Calendar.getInstance().apply {
            timeInMillis = run.timestamp
        }

        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        val textViewDate = findViewById<TextView>(R.id.tvDate)
        textViewDate.text = dateFormat.format(calenar.time)
//        holder.binding.tvDate.text = 

        val avgSpeed = "${run.averageInKMH}km/h"
        val textViewAvgSpeed = findViewById<TextView>(R.id.tvAvgSpeed)
        textViewAvgSpeed.text = avgSpeed
//        holder.binding.tvAvgSpeed.text = avgSpeed
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvAverageSpeed).text = avgSpeed

        val distanceInKm = "${run.distanceInMeters /1000f}km"
        val textViewDistance = findViewById<TextView>(R.id.tvDistance)
        textViewDistance.text = distanceInKm
//        holder.binding.tvDistance.text = distanceInKm
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvDistance).text = distanceInKm


        val textViewDuration = findViewById<TextView>(R.id.tvDuration)
        textViewDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
//        holder.binding.tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvTime).text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

        val caloriesBurned = "${run.caloriesBurned}kcal"
        val textViewCaloriesBurned = findViewById<TextView>(R.id.tvCaloriesBurned)
        textViewCaloriesBurned.text = caloriesBurned
//        holder.binding.tvCalories.text = caloriesBurned

    }

}