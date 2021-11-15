package com.example.myanimelist.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myanimelist.databinding.FragmentMainListBinding
import com.example.myanimelist.databinding.GridViewItemBinding
import com.example.myanimelist.viewmodel.MainListViewModel


class MainListFragment : Fragment() {

    private val viewModel: MainListViewModel by lazy {
        ViewModelProvider(this).get(MainListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMainListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }

}