package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.databinding.FragmentCalculateBinding
import com.example.loveapp.presenter.CalculateFragmentPresenter
import com.example.loveapp.presenter.CalculateView

class CalculateFragment : Fragment(), CalculateView {

    private var _binding: FragmentCalculateBinding? = null
    private val binding get() = _binding!!

    private val presenter: CalculateFragmentPresenter = CalculateFragmentPresenter(this)

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

        binding.btnCalculate.setOnClickListener {
            presenter.getPercentage(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToResult(loveModel: LoveModel) {
        binding.etFirstName.text.clear()
        binding.etSecondName.text.clear()
        findNavController().navigate(
            CalculateFragmentDirections.actionCalculateFragmentToResultFragment4(
                loveModel = loveModel
            )
        )
    }

    override fun showLoading() {
        binding.pbCalculate.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.pbCalculate.visibility = View.GONE
    }
}