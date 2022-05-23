package com.example.worldTour.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart_challenge_qv.databinding.CountriesItemBinding
import com.example.worldTour.model.CountriesDetails

class CountriesAdapter(
    private val countriesList: MutableList<CountriesDetails> = mutableListOf()
) : RecyclerView.Adapter<CountriesViewHolder>(){

    fun addCountries(countries: List<CountriesDetails>){
        countriesList.clear()
        countriesList.addAll(countries)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder =
        CountriesViewHolder(
            CountriesItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) =
        holder.bind(countriesList[position])

    override fun getItemCount(): Int = countriesList.size
}

class CountriesViewHolder(
    private val binding: CountriesItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind (countries: CountriesDetails){
        binding.apply {
            countryName.text = String.format(countries.name)
            countryRegion.text = countries.region
            countryCode.text = countries.code
            countrySeat.text = countries.capital
        }
    }

}