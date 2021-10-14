package com.example.homework3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    private lateinit var comm: Communicator
    private lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        val view: View = binding.root

        comm = requireActivity() as Communicator

        /*binding.value2.doAfterTextChanged   {
            comm.passDataCom2(binding.value2.text.toString())
        }*/

        binding.pls.setOnClickListener{
            comm.passDataCom3(binding.pls.text.toString())
        }
        binding.mns.setOnClickListener{
            comm.passDataCom3(binding.mns.text.toString())
        }
        binding.dvd.setOnClickListener{
            comm.passDataCom3(binding.dvd.text.toString())
        }
        binding.multi.setOnClickListener{
            comm.passDataCom3(binding.multi.text.toString())
        }

/*
        if (binding.pls.isChecked){
            comm.passDataCom3(binding.pls.text.toString())
        }
        else if (binding.mns.isChecked){
            comm.passDataCom3(binding.mns.text.toString())
        }
        else if (binding.dvd.isChecked){
            comm.passDataCom3(binding.dvd.text.toString())
        }
        else if (binding.multi.isChecked){
            comm.passDataCom3(binding.multi.text.toString())
        }
*/

        return view
    }
}