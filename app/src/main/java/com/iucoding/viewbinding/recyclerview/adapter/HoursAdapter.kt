package com.iucoding.viewbinding.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iucoding.viewbinding.databinding.HolderHoursCardBinding
import com.iucoding.viewbinding.model.HoursItem

class HoursAdapter(
    private val onItemClicked: (item: HoursItem) -> Unit
) : ListAdapter<HoursItem, HoursAdapter.HoursViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val binding = HolderHoursCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HoursViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        with(holder) {
            with(getItem(position)) {
                println("binding $this")
                binding.topLearnerName.text = name
                val hours = "$hours learning hours, $country"
                binding.topLearnerTime.text = hours

                holder.itemView.setOnClickListener {
                    onItemClicked(this)
                }
            }
        }
    }

    inner class HoursViewHolder(val binding: HolderHoursCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<HoursItem>() {
            override fun areItemsTheSame(oldItem: HoursItem, newItem: HoursItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: HoursItem, newItem: HoursItem): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.hours == newItem.hours &&
                        oldItem.country == newItem.country
            }
        }
    }
}
