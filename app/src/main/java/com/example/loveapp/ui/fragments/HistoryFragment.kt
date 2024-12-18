package com.example.loveapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveapp.App
import com.example.loveapp.databinding.FragmentHistoryBinding
import com.example.loveapp.ui.adapter.HistoryAdapter


class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val histAdapter = HistoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        getData()
    }

    private fun getData() {
        App.appDatabase?.resultDao()?.getAll()?.observe(viewLifecycleOwner) {
            histAdapter.submitList(it)
        }
    }

    private fun init() {
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = histAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}