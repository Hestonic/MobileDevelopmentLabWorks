package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {

    private lateinit var comm: Communicator
    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        val view: View = binding.root

        comm = requireActivity() as Communicator
        binding.value2.doAfterTextChanged   {
            comm.passDataCom2(binding.value2.text.toString())
        }

        return view
    }
}
