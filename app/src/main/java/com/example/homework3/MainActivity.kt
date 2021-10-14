package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.homework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding
    private var inputText: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragments = arrayOf(FragmentOne(), FragmentTwo(), FragmentThree(), FragmentFour())
        var count = 0

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val transaction = supportFragmentManager
            .beginTransaction()
            .add(R .id.fragment_container, fragments[count])
        transaction.commit()


        binding.next.setOnClickListener{
            count += 1

            when (count) {
                1 -> {
                    binding.fragment2.isEnabled = true
                    val transaction = supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragments[count])
                    transaction.commit()

                }
                2 -> {
                    binding.fragment3.isEnabled = true
                    val transaction = supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragments[count])
                    transaction.commit()

                }
                3 -> {
                    binding.fragment4.isEnabled = true
                    val value1 = (binding.value1.text.toString()).toFloat()
                    val value2 = (binding.value2.text.toString()).toFloat()
                    val operation = binding.operation.text.toString()
                    var result:Float = 0.toFloat()

                    when (operation) {
                        "+" -> result = value1 + value2
                        "-" -> result = value1 - value2
                        "*" -> result = value1 * value2
                        "/" -> result = value1 / value2
                    }

                    val bundle = Bundle()
                    bundle.putString("input_txt", result.toString())
                    fragments[count].arguments = bundle
                    val transaction = supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragments[count])
                    transaction.commit()


                    /*comm = requireActivity() as Communicator
                    binding.value2.doAfterTextChanged   {
                        comm.passDataCom2(binding.value2.text.toString())
                    }*/
                }
            }

            binding.next.isEnabled = false
            binding.back.isEnabled = true

        }

        binding.back.setOnClickListener{
            count -= 1
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R .id.fragment_container, fragments[count])
            transaction.commit()


            if (count == 0) binding.back.isEnabled = false

            binding.next.isEnabled = true
        }

        binding.fragment1.setOnClickListener{
            count = 0
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R .id.fragment_container, fragments[count])
            transaction.commit()

            binding.back.isEnabled = false
            binding.fragment2.isEnabled = false
            binding.fragment3.isEnabled = false
            binding.fragment4.isEnabled = false
        }

        binding.fragment2.setOnClickListener{
            count = 1
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R .id.fragment_container, fragments[count])
            transaction.commit()


            binding.back.isEnabled = true
            binding.fragment3.isEnabled = false
            binding.fragment4.isEnabled = false
        }

        binding.fragment3.setOnClickListener{
            count = 2
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R .id.fragment_container, fragments[count])
            transaction.commit()


            binding.back.isEnabled = true
            binding.fragment4.isEnabled = false
        }

        binding.fragment4.setOnClickListener{
            count = 3
            val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R .id.fragment_container, fragments[count])
            transaction.commit()


            binding.back.isEnabled = true
            binding.next.isEnabled = false
        }

        binding.value1.doAfterTextChanged {
            binding.next.isEnabled = binding.value1.text.toString().isNotEmpty()
        }

        binding.value2.doAfterTextChanged {
            binding.next.isEnabled = binding.value2.text.toString().isNotEmpty()
        }

        binding.operation.doAfterTextChanged {
            binding.next.isEnabled = binding.operation.text.toString().isNotEmpty()
        }
    }

    override fun passDataCom1(editTextInput: String) {
        binding.value1.text = editTextInput
    }

    override fun passDataCom2(editTextInput: String) {
        binding.value2.text = editTextInput
    }

    override fun passDataCom3(editTextInput: String) {
        binding.operation.text = editTextInput
    }




}



