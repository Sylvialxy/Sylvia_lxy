package com.liuxinyu.dreamscape.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setupRegisterButton()
        return binding.root
    }

    private fun setupRegisterButton() {
        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (isUsernameValid(username)) {
                if (registerUser(username, password)) {
                    // 注册成功，处理相关逻辑
                    binding.tvError.text = "Registration successful!"
                } else {
                    binding.tvError.text = "Registration failed. An error occurred."
                }
            } else {
                binding.tvError.text = "Username already exists. Please choose a different username."
            }
        }
    }

    private fun isUsernameValid(username: String): Boolean {
        // 在此实现检查用户名是否已存在的逻辑
        // 这里简单示例，始终返回 true，需要根据实际情况进行处理
        return true
    }

    private fun registerUser(username: String, password: String): Boolean {
        // 在此实现将用户名和密码注册的逻辑
        // 这里简单示例，始终返回 true，需要根据实际情况进行处理
        return true
    }
}