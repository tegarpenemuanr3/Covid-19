package com.tegarpenemuan.covid_19.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tegarpenemuan.covid_19.data.api.CovidProvinceResponse
import com.tegarpenemuan.covid_19.databinding.CovidListItemBinding

/**
 * com.tegarpenemuan.covid_19.ui
 *
 * Created by Tegar Penemuan on 25/05/2022.
 * https://github.com/tegarpenemuanr3
 *
 */

class CovidAdapter(
    private var list: List<CovidProvinceResponse.ListData>
) :
    RecyclerView.Adapter<CovidAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CovidListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<CovidProvinceResponse.ListData>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CovidListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvProvinsi.text = "Provinsi : "+item.key
        holder.binding.tvKasus.text = "Kasus : "+item.jumlahKasus.toString()
        holder.binding.tvMeninggal.text = "Meninggal : "+item.jumlahMeninggal.toString()
        holder.binding.tvSembuh.text = "Sembuh : "+item.jumlahSembuh.toString()
        holder.binding.tvRawat.text = "Dirawat : "+item.jumlahDirawat.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}