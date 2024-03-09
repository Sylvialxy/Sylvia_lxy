package com.liuxinyu.dreamscape.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置页面内容，包括标题、字体颜色等
        binding.btnSignIn.setOnClickListener {
            // 处理登录按钮点击事件
            // 使用 Navigation 组件进行页面导航到登录页面
            findNavController().navigate(R.id.fragment_login)
        }
    }
}