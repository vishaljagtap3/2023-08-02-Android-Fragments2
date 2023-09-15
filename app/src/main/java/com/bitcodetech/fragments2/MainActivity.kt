package com.bitcodetech.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.bitcodetech.fragments2.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counterFragments = ArrayList<CounterFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()

    }

    private fun initListeners() {
        binding.btnAddCounter.setOnClickListener {

            /*val counterFragment = CounterFragment(
                binding.edtTitle.text.toString(),
                binding.edtCount.text.toString().toInt()
            )*/

            val inputBundle = Bundle()
            inputBundle.putString("title", binding.edtTitle.text.toString())
            inputBundle.putInt("count", binding.edtCount.text.toString().toInt())

            val counterFragment = CounterFragment()
            counterFragment.arguments = inputBundle

            val fragmentTransaction: FragmentTransaction =
                supportFragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.mainContainer, counterFragment, null)
            fragmentTransaction.addToBackStack("transaction name")
            fragmentTransaction.commit()

            counterFragments.add(counterFragment)
        }

        binding.btnRemoveCounter.setOnClickListener {

            if(counterFragments.size == 0) {
                return@setOnClickListener
            }

            val counterFragment = counterFragments[counterFragments.size - 1]

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(counterFragment)
            //fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

            counterFragments.remove(counterFragment)
        }
    }
}