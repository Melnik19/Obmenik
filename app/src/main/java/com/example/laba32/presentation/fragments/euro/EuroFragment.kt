package com.example.laba32.presentation.fragments.euro

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laba32.R
import com.example.laba32.data.model.bezgotivkaItem
import com.example.laba32.databinding.FragmentEuroBinding

class EuroFragment : Fragment(R.layout.fragment_euro) {
    lateinit var binding: FragmentEuroBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEuroBinding.bind(view)

        var listEuroBezGot: List<bezgotivkaItem>

        var viewModel = ViewModelProvider(this).get(EuroViewModel::class.java)
        viewModel.getEuro()

        viewModel.Eurolist.observe(viewLifecycleOwner) { list ->
            listEuroBezGot = list.body()!!
            bindBezGot(listEuroBezGot)
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_euroFragment_to_dollarsFragment)
        }
    }

    private fun bindBezGot(listDollarsBezGot: List<bezgotivkaItem>) {
        with(binding){
            //готівковий курс
            text2.text = (listDollarsBezGot[0].buy)
            text3.text = (listDollarsBezGot[0].sale)
        }
    }

}