package com.example.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.runningapp.R
import com.example.runningapp.databinding.FragmentSettingsBinding
import com.example.runningapp.other.Constance.KEY_NAME
import com.example.runningapp.other.Constance.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    
    private lateinit var binding: FragmentSettingsBinding
    
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        loadFiledsFromSharedPref()
        binding.btnApplyChanges.setOnClickListener { 
            val success = applyChangesToSharedPref()
            if(success) {
                Snackbar.make(view,"You have successfully shanged",Snackbar.LENGTH_LONG).show()
            }else{
                Snackbar.make(view,"Please fill out all the fields",Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun loadFiledsFromSharedPref() {
        val name  = sharedPreferences.getString(KEY_NAME,"")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT,80f)
        
        binding.etName.setText(name)
        binding.etWeight.setText(weight.toString())
    }
    private fun applyChangesToSharedPref() : Boolean {
        val nameText = binding.etName.text.toString()
        val weightText = binding.etWeight.text.toString()
        
        if(nameText.isEmpty() || weightText.isEmpty()){
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME,nameText)
            .putFloat(KEY_WEIGHT,weightText.toFloat())
            .apply()
        val toolBarText = "Lets go ${nameText}"
        requireActivity().findViewById<MaterialTextView>(R.id.tvToolbarTitle).text = toolBarText
        return true
    }
    
}