package com.syntax_institut.whatssyntax.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.databinding.ItemContactBinding

class StatusAdapter(
    private val dataset: List<Contact>,
    private val viewModel: MainViewModel
): RecyclerView.Adapter<StatusAdapter.StautsViewHolder>() {
    inner class StautsViewHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StautsViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StautsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: StautsViewHolder, position: Int) {
        val contact = dataset[position]

        holder.binding.tvContactName.text = contact.name
        holder.binding.ivContactImage.load(contact.image)

        holder.binding.root.setOnClickListener {
            viewModel.selectContact(contact)
            holder.itemView.findNavController().navigate(R.id.statusDetailFragment)
        }
    }
}