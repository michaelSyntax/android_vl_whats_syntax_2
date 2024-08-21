package com.syntax_institut.whatssyntax.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.whatssyntax.MainViewModel
import com.syntax_institut.whatssyntax.data.model.Profile
import com.syntax_institut.whatssyntax.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btProfileSave.setOnClickListener {
            val newName = binding.tietProfileName.text.toString()
            val number = binding.tietProfileNumber.text.toString()
            val newProfile = Profile(newName, number, "")
            viewModel.setProfile(newProfile)
        }
    }
}