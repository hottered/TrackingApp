package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertRun(run:Run) : Long
    
    @Delete
    fun deleteRun(run:Run)
    
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMilliseconds() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY averageInKMH DESC")
    fun getAllRunSortedByAverageSpeed() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunSortedByDistance() : LiveData<List<Run>>


    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>
    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned() : LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistance() : LiveData<Int>

    @Query("SELECT AVG(averageInKMH) FROM running_table")
    fun getTotalAverageSpeed() : LiveData<Float>
    
}