package com.liuxinyu.dreamscape.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 设置按钮点击事件
        binding.btnSignIn.setOnClickListener {
            // 使用 Navigation 组件导航到 LoginFragment
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        }

        return binding.root
    }

    // 其他相关操作...
}