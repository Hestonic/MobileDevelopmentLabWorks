package com.example.homework6.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework6.MAIN
import com.example.homework6.R
import com.example.homework6.databinding.FragmentChildrenBinding
import com.example.homework6.model.Parent
import com.example.homework6.fragments.add.viewmodel.UserViewModel

class ChildrenFragment : Fragment() {

    private lateinit var binding: FragmentChildrenBinding
    private lateinit var mUserViewModel: UserViewModel
    private val args by navArgs<ParentFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChildrenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recycler
        val adapter = ChildrenAdapter(args.id, args.node) { parentId, father, children, isFilled ->
            if (isFilled == 1) {
                AlertDialog.Builder(MAIN)
                    .setTitle("Delete Relation?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes") { _, _ ->
                        val parent = Parent(parentId, father, children)
                        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
                        mUserViewModel.deleteParent(parent)
                        MAIN.navController.navigate(R.id.action_childrenFragment_to_listFragment)
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
                        MAIN.navController.navigate(R.id.action_childrenFragment_to_listFragment)
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

        binding.parentBtn.setOnClickListener {
            val action = ChildrenFragmentDirections.actionChildrenFragmentToParentFragment(args.id, args.node)
            MAIN.navController.navigate(action)
        }
    }
}