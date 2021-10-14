package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.FragmentFourBinding

class FragmentFour : Fragment() {

    private var inputText: String? = ""
    private lateinit var comm: Communicator
    private lateinit var binding: FragmentFourBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourBinding.inflate(inflater, container, false)
        val view: View = binding.root

        inputText = arguments?.getString("input_txt")
        binding.result.text = inputText



        return view
    }
}