package com.liuxinyu.dreamscape.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuxinyu.dreamscape.R
import com.liuxinyu.dreamscape.databinding.FragmentLoginBinding
import java.security.MessageDigest


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 在这里设置 LoginFragment 页面的 UI 元素
        binding.btnSignIn.setOnClickListener {
            val username = binding.userName.text.toString()
            val password = binding.userPassword.text.toString()

            // 对密码进行 SHA 加密
            val hashedPassword = hashString(password)

            // TODO: 进行用户名和密码的验证，验证成功后跳转到其他 Fragment
            if (validateCredentials(username, hashedPassword)) {
                // 跳转到其他 Fragment
            } else {
                binding.tvErrorMessage.text = "Authentication failed. Incorrect username or password."
            }
        }
    }

    private fun hashString(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private fun validateCredentials(username: String, hashedPassword: String): Boolean {
        // TODO: 进行用户名和密码的实际验证逻辑
        return true
    }
}