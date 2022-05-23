package com.example.worldTour.fragments

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.worldTour.viewmodel.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected val countriesViewModel: CountriesViewModel by viewModels()

    fun errorBox(
        message: String = "a build error has occurred, please select an option",
        retry: () -> Unit){
            AlertDialog.Builder(requireContext())
                .setTitle(".")
                .setNegativeButton("cancel"){
                        dialog, _ -> dialog.dismiss()
                }
                .setPositiveButton("Reload"){
                    dialog, _ -> dialog.dismiss()
                    retry()
                }
                .setMessage(message)
                .create()
                .show()
        }

}