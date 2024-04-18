package com.works.service

import com.works.model.VendorList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerService {
    @GET("/2/food")
    fun getFoodVendors() : Call<List<VendorList>>
    @GET("/3/grocery")
    fun getGroceryVendors() : Call<List<VendorList>>
    @GET("/4/pharmacy")
    fun getPharmacyVendors() : Call<List<VendorList>>
    @GET("search/{keyword}")
    fun searchVendor(@Path("keyword") keyword : String) : Call<List<VendorList>>


}