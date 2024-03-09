package com.liuxinyu.dreamscape

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liuxinyu.dreamscape.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            // 在此处添加注册逻辑，完成注册后跳转到登录页面
            // 示例：假设注册成功后直接跳转到登录页面
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}