package com.example.homework6.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework6.MAIN
import com.example.homework6.R
import com.example.homework6.databinding.FragmentParentBinding
import com.example.homework6.model.Parent
import com.example.homework6.fragments.add.viewmodel.UserViewModel

class ParentFragment : Fragment() {

    private lateinit var binding: FragmentParentBinding
    private lateinit var mUserViewModel: UserViewModel
    private val args by navArgs<ParentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // recycler
        val adapter = ParentAdapter(args.id, args.node) { parentId, father, children, isFilled ->
            if (isFilled == 1) {
                AlertDialog.Builder(MAIN)
                    .setTitle("Delete Relation?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes") { _, _ ->
                        val parent = Parent(parentId, father, children)
                        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
                        mUserViewModel.deleteParent(parent)
                        MAIN.navController.navigate(R.id.action_parentFragment_to_listFragment)
                    }
                    .show()
            }
            if (isFilled == 0) {
                AlertDialog.Builder(MAIN)
                    .setTitle("Add Relation?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes") { _, _ ->
                        val parent = Parent(0, father, children)
                        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
                        mUserViewModel.addParent(parent)
                        MAIN.navController.navigate(R.id.action_parentFragment_to_listFragment)
                    }
                    .show()
            }
        }

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

        binding.childrenBtn.setOnClickListener {
            val action = ParentFragmentDirections.actionParentFragmentToChildrenFragment2(args.id, args.node)
            MAIN.navController.navigate(action)
        }
    }
}


/*
if (isFilled) {
    AlertDialog.Builder(MAIN)
        .setTitle("Delete Relation?")
        .setNegativeButton("No", null)
        .setPositiveButton("Yes") { _, _ ->
            val parent = Parent(0, father, children)
            mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
            mUserViewModel.deleteParent(parent)
            MAIN.navController.navigate(R.id.action_parentFragment_to_listFragment)
        }
        .show()
    // связи не существует - добавляем
} else {
    AlertDialog.Builder(MAIN)
        .setTitle("Add Relation?")
        .setNegativeButton("No", null)
        .setPositiveButton("Yes") { _, _ ->
            val parent = Parent(0, father, children)
            mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
            mUserViewModel.addParent(parent)
            MAIN.navController.navigate(R.id.action_parentFragment_to_listFragment)
        }
        .show()
}*/
