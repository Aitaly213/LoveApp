package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.loveapp.App
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupListener()
       // sendDataToRoom()
    }

    private fun setupListener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun init() {

        args.loveModel.apply {
            binding.tvFirstName.text = firstName
            binding.tvSecondName.text = secondName
            binding.tvLovePercentage.text = "${percentage}%"
            binding.tvLoveResult.text = result
        }

    }


}