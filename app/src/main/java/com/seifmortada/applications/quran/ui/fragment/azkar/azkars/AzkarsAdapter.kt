package com.seifmortada.applications.quran.ui.fragment.azkar.azkars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.AzkarModel
import com.seifmortada.applications.quran.databinding.ItemAzkarsBinding
import com.seifmortada.applications.quran.ui.core.BaseRecyclerAdapter
import com.seifmortada.applications.quran.utils.FunctionsUtils.normalizeTextForFiltering

class AzkarsAdapter()
    : BaseRecyclerAdapter<AzkarModel, AzkarsAdapter.AzkarsViewHolder>() {

    inner class AzkarsViewHolder(val binding: ItemAzkarsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(zikr: AzkarModel) {
            binding.zikrName.text = zikr.category
            binding.zikrNumber.text = zikr.id.toString()
        }
    }

    override fun onCreateCustomViewHolder(parent: ViewGroup, viewType: Int): AzkarsViewHolder {
        return AzkarsViewHolder(
            ItemAzkarsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindCustomViewHolder(holder: AzkarsViewHolder, position: Int) {
        val currentZirk = filteredItems[position]
        holder.bind(currentZirk)    }


    override fun filterItem(item: AzkarModel, query: String): Boolean {
        return normalizeTextForFiltering(item.category.lowercase()).contains(query)
    }
}