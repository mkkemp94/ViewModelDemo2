package com.mkemp.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mkemp.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = MainActivityViewModelFactory(125.0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.totalData.observe(this, {
            binding.textView.text = it?.toString()
        })

        binding.button.setOnClickListener {
            viewModel.setTotal(binding.editText.text.toString().toDouble())
        }
    }
}