package com.tegarpenemuan.covid_19.data.api

import com.google.gson.annotations.SerializedName

data class CovidProvinceResponse(
    @SerializedName("last_date") var lastDate: String? = null,
    @SerializedName("current_data") var currentData: Int? = null,
    @SerializedName("missing_data") var missingData: Int? = null,
    @SerializedName("tanpa_provinsi") var tanpaProvinsi: Int? = null,
    @SerializedName("list_data") var listData: List<ListData> = emptyList()
) {
    data class ListData(
        @SerializedName("key") var key: String? = null,
        @SerializedName("doc_count") var docCount: Double? = null,
        @SerializedName("jumlah_kasus") var jumlahKasus: Int? = null,
        @SerializedName("jumlah_sembuh") var jumlahSembuh: Int? = null,
        @SerializedName("jumlah_meninggal") var jumlahMeninggal: Int? = null,
        @SerializedName("jumlah_dirawat") var jumlahDirawat: Int? = null,
    )
}