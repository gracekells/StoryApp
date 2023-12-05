package com.dicoding.storyapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import com.dicoding.storyapp.R
import com.dicoding.storyapp.databinding.ActivityMainBinding
import com.dicoding.storyapp.databinding.ActivityRegisterBinding
import com.dicoding.storyapp.viewmodel.AuthViewModel
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.btnRegister.setOnClickListener{
            val name = binding.edRegisterName.text.toString()
            val email = binding.edRegiterEmail.text.toString()
            val password = binding.edRegiterPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                registerUser(name, email, password)
            } else {
                showSnackbar("Please fill in all fields")
            }
        }

        binding.tvLogin.setOnClickListener{
            navigateToLogin()
        }
    }

    private fun registerUser(name: String, email: String, password: String){
        authViewModel.register(name, email, password)
        authViewModel.authenticationStatus.observe(this, { success ->
            if (success){
                showSnackbar("Registration successful")
                navigateToLogin()
            } else{
                showSnackbar("Registration failed. Please try again.")
            }
        })
    }

    private fun navigateToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSnackbar(message: String){
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }
}