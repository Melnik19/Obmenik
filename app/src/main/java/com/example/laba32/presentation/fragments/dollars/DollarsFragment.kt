package com.example.laba32.presentation.fragments.dollars

import androidx.lifecycle.ViewModelProvider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laba32.R
import com.example.laba32.data.model.bezgotivkaItem
import com.example.laba32.databinding.FragmentDollarsBinding

class DollarsFragment : Fragment(R.layout.fragment_dollars) {
    lateinit var binding: FragmentDollarsBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDollarsBinding.bind(view)

        var listDollarsBezGot: List<bezgotivkaItem>

        val viewModel = ViewModelProvider(this).get(DollarsViewModel::class.java)
        viewModel.getDollar()

        viewModel.Dollarlisr.observe(viewLifecycleOwner) { list ->
            listDollarsBezGot = list.body()!!
            bindGot(listDollarsBezGot)
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_dollarsFragment_to_euroFragment)
        }

    }

    private fun bindGot(listDollarsBezGot: List<bezgotivkaItem>) {
        with(binding){
            //готівковий курс
            text2.text = (listDollarsBezGot[1].buy)
            text3.text = (listDollarsBezGot[1].sale)
        }
    }

}