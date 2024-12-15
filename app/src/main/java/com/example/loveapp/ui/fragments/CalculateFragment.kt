package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loveapp.BuildConfig
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.data.network.RetrofitInstance
import com.example.loveapp.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment() {

    private var _binding :FragmentCalculateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentCalculateBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            RetrofitInstance.api.getPercentage(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString(),
                BuildConfig.API_KEY,
                BuildConfig.HOST
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        binding.etFirstName.text.clear()
                        binding.etSecondName.text.clear()
                        findNavController().navigate(
                            CalculateFragmentDirections.actionCalculateFragmentToResultFragment4(
                                loveModel = response.body()!!
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}