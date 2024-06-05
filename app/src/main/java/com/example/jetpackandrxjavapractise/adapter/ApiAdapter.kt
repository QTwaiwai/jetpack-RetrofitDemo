package com.example.jetpackandrxjavapractise.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackandrxjavapractise.R
import com.example.jetpackandrxjavapractise.bean.Story

class ApiAdapter : ListAdapter<Story, ApiAdapter.SimpleHolder>(object : DiffUtil.ItemCallback<Story>() {

        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.title == newItem.title
        }

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_left, parent, false)
        return SimpleHolder((itemView))
    }

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }

    inner class SimpleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tv_item_left)
        fun bind(itemData: Story) {
            textView.text = itemData.title
        }
    }

}