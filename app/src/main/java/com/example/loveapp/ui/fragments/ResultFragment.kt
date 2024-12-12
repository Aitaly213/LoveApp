package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.loveapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private val binding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupListener()
    }

    private fun setupListener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToCalculateFragment2())
        }
    }

    private fun init() {
        binding.tvFirstName.text = args.firstName
        binding.tvSecondName.text = args.secondName
        binding.tvLovePercentage.text = "${args.percentage}%"
        binding.tvLoveResult.text = args.result
    }


}