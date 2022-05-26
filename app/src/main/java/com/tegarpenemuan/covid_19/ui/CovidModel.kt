package com.tegarpenemuan.covid_19.ui

/**
 * com.tegarpenemuan.covid_19.ui
 *
 * Created by Tegar Penemuan on 25/05/2022.
 * https://github.com/tegarpenemuanr3
 *
 */

data class CovidModel(
    val key: String,
    val jumlah_kasus: String,
    val jumlah_sembuh: String,
    val jumlah_meninggal: String,
    val jumlah_dirawat: String
)