package com.seifmortada.applications.quran.presentation.features.reciters_feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ReciterModel
import com.seifmortada.applications.quran.databinding.ItemRecitersBinding
import com.seifmortada.applications.quran.presentation.core.BaseRecyclerAdapter
import com.seifmortada.applications.quran.utils.FunctionsUtils.normalizeTextForFiltering

class RecitersAdapter : BaseRecyclerAdapter<ReciterModel, RecitersAdapter.RecitersViewHolder>() {

    inner class RecitersViewHolder(val binding: ItemRecitersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reciter: ReciterModel) {
            binding.apply {
                reciterName.text = reciter.name
                moushafNumber.text = reciter.moshaf.size.toString()
            }
            itemView.setOnClickListener {
                it.findNavController().navigate(
                    RecitersFragmentDirections.actionRecitersFragmentToReciterMoshafFragment(
                        reciter
                    )
                )
            }
        }
    }

    override fun onCreateCustomViewHolder(parent: ViewGroup, viewType: Int): RecitersViewHolder {
        return RecitersViewHolder(
            ItemRecitersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindCustomViewHolder(holder: RecitersViewHolder, position: Int) {
        holder.bind(filteredItems[position])
    }

    override fun filterItem(item: ReciterModel, query: String): Boolean {
        return normalizeTextForFiltering(item.name.lowercase()).contains(query)
    }
}