package com.example.homework6.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework6.MAIN
import com.example.homework6.R
import com.example.homework6.databinding.FragmentListBinding
import com.example.homework6.viewmodel.UserViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView
        val adapter = ListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        //User View Model
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.readAllData.observe(viewLifecycleOwner, { user ->
            adapter.setData(user)
        })

        mUserViewModel.readAllDataParents.observe(viewLifecycleOwner, { parent ->
            adapter.setDataParent(parent)
        })

        binding.floatBtn.setOnClickListener {
            MAIN.navController.navigate(R.id.action_listFragment_to_addFragment)
        }

        // удалить все записи из БД
        binding.clearBtn.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder
                .setTitle("Delete everything?")
                .setMessage("Are you sure you want delete everything?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes") { _, _ ->
                mUserViewModel.deleteAllParent()
                mUserViewModel.deleteAllUser()
                Toast.makeText(
                    requireContext(),
                    "Successfully removed everything",
                    Toast.LENGTH_LONG).show()
            }
                .create().show()
        }
    }
}