package com.example.runningapp.ui.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.example.runningapp.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel(),LifecycleObserver{
    
    val totalTimeRun = mainRepository.getTotalTimeInMillis()
    val totalDistance = mainRepository.getTotalDistance()
    val totalCaloriesBurned=  mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = mainRepository.getTotalAvgSpeed()
    
    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()
    
}