package com.syntax_institut.whatssyntax.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax_institut.whatssyntax.databinding.ItemCallBinding


class CallAdapter(
    private val context: Context,
    private val dataset: List<Any>
): RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    inner class CallViewHolder(val binding: ItemCallBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val item = dataset[position]
        TODO()
    }

}