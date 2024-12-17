package com.example.loveapp.presenter

import com.example.loveapp.BuildConfig
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragmentPresenter(private val view: CalculateView) {

   fun getPercentage(firstName: String,secondName: String){
       view.showLoading()
       RetrofitInstance.api.getPercentage(
           firstName,
           secondName,
           BuildConfig.API_KEY,
           BuildConfig.HOST
       ).enqueue(object : Callback<LoveModel>{
           override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
               if (response.isSuccessful && response.body() != null) {
                   view.navigateToResult(response.body()!!)
                   view.hideLoading()
               }
           }

           override fun onFailure(call: Call<LoveModel>, t: Throwable) {
               view.showError(t.message.toString())
           }

       })
   }


}