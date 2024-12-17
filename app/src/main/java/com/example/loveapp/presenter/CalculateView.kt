package com.example.loveapp.presenter

import com.example.loveapp.data.model.LoveModel

interface CalculateView {
    fun showError(message: String)
    fun navigateToResult(loveModel: LoveModel)

    fun showLoading()
    fun hideLoading()
}