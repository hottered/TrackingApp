package com.example.runningapp.repositories

import com.example.runningapp.db.Run
import com.example.runningapp.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
     fun insertRun(run:Run) {
        runDao.insertRun(run)
    }
    suspend fun deleteRun(run:Run) {
        runDao.deleteRun(run)
    }
    
    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByDate()
    fun getAllRunsSortedByDistance() = runDao.getAllRunSortedByDistance()
    fun getAllRunsSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMilliseconds()
    fun getAllRunsSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()
    fun getAllRunSortedByAverageSpeed() = runDao.getAllRunSortedByAverageSpeed()
    fun getTotalAvgSpeed() = runDao.getTotalAverageSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
}