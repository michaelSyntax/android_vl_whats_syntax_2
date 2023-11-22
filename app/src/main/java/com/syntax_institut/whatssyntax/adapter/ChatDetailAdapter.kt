package com.syntax_institut.whatssyntax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.databinding.ItemChatInBinding
import com.syntax_institut.whatssyntax.databinding.ItemChatOutBinding

class ChatDetailAdapter(
    private val dataset: MutableList<Any>,
    private val viewModel: MainViewModel
): RecyclerView.Adapter<ViewHolder>() {

    fun sendNewMessage(message: Any) {
        dataset.add(message)
        notifyItemInserted(dataset.size-1)
    }

    private val outType = 1
    private val inType = 2

    inner class MessageOutViewHolder(val binding: ItemChatOutBinding): RecyclerView.ViewHolder(binding.root)

    inner class MessageInViewHolder(val binding: ItemChatInBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        TODO()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == inType) {
            val binding = ItemChatInBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            MessageInViewHolder(binding)
        } else {
            val binding = ItemChatOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            MessageOutViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        TODO()
    }

}