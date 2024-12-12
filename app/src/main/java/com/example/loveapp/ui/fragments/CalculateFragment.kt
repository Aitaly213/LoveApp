package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.data.network.RetrofitInstance
import com.example.loveapp.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment() {

    private val binding by lazy {
        FragmentCalculateBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            RetrofitInstance.api.getPercentage(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString(),
                KEY,
                HOST
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        findNavController().navigate(
                            CalculateFragmentDirections.actionCalculateFragmentToResultFragment4(
                                firstName = response.body()!!.firstName,
                                secondName = response.body()!!.secondName,
                                percentage = response.body()!!.percentage,
                                result = response.body()!!.result
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


    companion object {
        const val KEY = "11e7e1a9c9msh4bbfd5f88f3991bp10653bjsn6bd04c5d5ac2"
        const val HOST = "love-calculator.p.rapidapi.com"
    }
}