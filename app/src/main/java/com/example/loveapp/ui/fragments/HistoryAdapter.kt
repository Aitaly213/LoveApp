package com.example.loveapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.databinding.FragmentHistoryBinding
import com.example.loveapp.databinding.ItemHistoryBinding

class HistoryAdapter() : ListAdapter<LoveModel, HistoryAdapter.ViewHolder>(DiffUtilComeback()) {

    class ViewHolder(private val binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(loveModel: LoveModel) {
            binding.tvFirstName.text = loveModel.firstName
            binding.tvSecondName.text = loveModel.secondName
            binding.tvPercentage.text = loveModel.percentage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding by lazy {
            ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class DiffUtilComeback : DiffUtil.ItemCallback<LoveModel>() {
    override fun areItemsTheSame(oldItem: LoveModel, newItem: LoveModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LoveModel, newItem: LoveModel): Boolean {
        return oldItem.id == newItem.id
    }

}
