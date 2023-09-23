package com.example.runningapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runningapp.R
import com.example.runningapp.databinding.ItemRunBinding
import com.example.runningapp.db.Run
import com.example.runningapp.other.TrackingUtility
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

//    inner class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class RunViewHolder(val binding: ItemRunBinding) : RecyclerView.ViewHolder(binding.root)
    

    //two list and calculate the difference between them 
    //update only items which are different
    //goes thourgh the list and see which items to update and also add new items
    val diffCallBack = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
            //hasCoade calcutaes the has value of the items result of oneway function which cannot be calucated back 
            //100% items are the same not only the id , also the properties are the same avgSpeed and so on...
            
        }

    }
    val differ = AsyncListDiffer(this,diffCallBack)
    
    fun submitList(list:List<Run>){
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder(ItemRunBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run  = differ.currentList[position]
        holder.itemView.apply { 
            Glide.with(holder.itemView)
                .load(run.img)
                .into(holder.binding.ivRunImage)
            val calenar  = Calendar.getInstance().apply { 
                timeInMillis = run.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            holder.binding.tvDate.text = dateFormat.format(calenar.time)
            
            val avgSpeed = "${run.averageInKMH}km/h"
            holder.binding.tvAvgSpeed.text = avgSpeed
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvAverageSpeed).text = avgSpeed
            
            val distanceInKm = "${run.distanceInMeters /1000f}km"
            holder.binding.tvDistance.text = distanceInKm
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvDistance).text = distanceInKm

            holder.binding.tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvTime).text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)
            
            val caloriesBurned = "${run.caloriesBurned}kcal"
            holder.binding.tvCalories.text = caloriesBurned
//            holder.itemView.findViewById<MaterialTextView>(R.id.tvCalories).text = caloriesBurned
            
        }
    }
}