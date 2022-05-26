package com.tegarpenemuan.covid_19.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tegarpenemuan.covid_19.data.api.CovidProvinceResponse
import com.tegarpenemuan.covid_19.repository.CovidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * com.tegarpenemuan.covid_19.ui
 *
 * Created by Tegar Penemuan on 25/05/2022.
 * https://github.com/tegarpenemuanr3
 *
 */

@HiltViewModel
class CovidViewModel @Inject constructor(
    private val repository: CovidRepository
): ViewModel() {
    val showData: MutableLiveData<CovidProvinceResponse> = MutableLiveData()
    val showError: MutableLiveData<String> = MutableLiveData()

    fun getCovidProvince() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = repository.getCovidProvince()
            withContext(Dispatchers.Main) {
                if (result.isSuccessful) {
                    // show data
                    val data = result.body()
                    showData.postValue(data!!)
                } else {
                    // show error
                    val data = result.errorBody()
                    showError.postValue(data.toString())
                }
            }
        }
    }
}