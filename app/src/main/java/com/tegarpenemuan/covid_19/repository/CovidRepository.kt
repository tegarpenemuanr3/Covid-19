package com.tegarpenemuan.covid_19.repository

import com.tegarpenemuan.covid_19.data.api.CovidAPI
import com.tegarpenemuan.covid_19.data.api.CovidProvinceResponse
import retrofit2.Response
import javax.inject.Inject

class CovidRepository @Inject constructor(
    private val api: CovidAPI
) {
    //Ambil data dari API
    suspend fun getCovidProvince(): Response<CovidProvinceResponse> {
        return api.getCovidProvince()
    }

}