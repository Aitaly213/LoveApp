package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.databinding.FragmentCalculateBinding
import com.example.loveapp.ui.viewmodels.LoveViewModel

class CalculateFragment : Fragment() {

    private var _binding: FragmentCalculateBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[LoveViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalculateBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCalculate.setOnClickListener {
            viewModel.getPercentage(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            )

            viewModel.loveResult.observe(viewLifecycleOwner) { result ->
                if (result != null) {
                    binding.etFirstName.text.clear()
                    binding.etSecondName.text.clear()
                    findNavController().navigate(
                        CalculateFragmentDirections.actionCalculateFragmentToResultFragment4(
                            LoveModel(
                                result.firstName,
                                result.secondName,
                                result.percentage,
                                result.result
                            )
                        )
                    )
                }
            }

            viewModel.error.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }

            viewModel.loadingProgressBar.observe(viewLifecycleOwner) {
                if (it) binding.pbCalculate.visibility = View.VISIBLE
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}