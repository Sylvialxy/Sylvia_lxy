package com.liuxinyu.dreamscape

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liuxinyu.dreamscape.databinding.ActivityLoginBinding
import com.liuxinyu.dreamscape.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            // 在此处添加登录逻辑，检查用户名和密码是否匹配
            // 如果匹配，启动 MainActivity，否则显示错误提示
            // 示例：假设用户名为 "user"，密码为 "password"
            val enteredUsername = binding.etUsername.text.toString()
            val enteredPassword = binding.etPassword.text.toString()
            if (enteredUsername == "user" && enteredPassword == "password") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                binding.tvError.text = "认证失败，用户名或密码错误"
            }
        }
    }
}