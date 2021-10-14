package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private lateinit var comm: Communicator
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val view: View = binding.root

        comm = requireActivity() as Communicator
        binding.value1.doAfterTextChanged   {
            comm.passDataCom1(binding.value1.text.toString())
        }


        return view
    }
}
