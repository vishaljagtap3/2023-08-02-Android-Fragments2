package com.bitcodetech.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.fragments2.databinding.CounterFragmentBinding

//class CounterFragment(
//    private val title: String?,
//    private var count: Int = 0
//) : Fragment() {

class CounterFragment() : Fragment() {

    private lateinit var binding: CounterFragmentBinding
    private var count = 0

    //constructor() : this(null, 0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CounterFragmentBinding.inflate(inflater)
        initViews()

        initListeners()

        return binding.root
    }

    private fun initViews() {
        binding.txtTitle.text = arguments?.getString("title")
        count = arguments?.getInt("count")!!
        binding.txtCount.text = "$count"
    }

    private fun initListeners() {
        binding.btnDecrement.setOnClickListener {
            binding.txtCount.text = "${--count}"
        }

        binding.btnIncrement.setOnClickListener {
            binding.txtCount.text = "${++count}"
        }
    }

}