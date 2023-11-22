package com.hengki.aplicationtest.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hengki.aplicationtest.core.source.remote.request.RegisterRequest
import com.hengki.aplicationtest.core.source.remote.network.State
import com.hengki.aplicationtest.databinding.ActivityRegisterBinding
import com.hengki.aplicationtest.ui.base.MyActivity
import com.hengki.aplicationtest.util.Constants
import com.hengki.aplicationtest.util.defaultError
import com.hengki.aplicationtest.util.showZenConfirmDialog
import com.inyongtisto.myhelper.extension.getStringExtra
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : MyActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun init() {
        binding.apply {
            getStringExtra()?.let {
                edtEmail.setText(it)
                edtEmail.isFocusable = false
            }
        }
    }

    private fun mainButton(){
        binding.apply {
            btnRegister.setOnClickListener {
                register()
            }
        }
    }

    private fun register() {
        val regex = Regex("[^A-Za-z0-9 ]")
        binding.apply {
            if (!validate()) return
            val user = RegisterRequest(
                email = edtEmail.text.toString(),
                name = edtName.text.toString(),
                password = edtPassword.text.toString(),


                )

            viewModel.register(user).observe(this@RegisterActivity) {
                when (it.state) {
                    State.SUCCESS -> {
                        pushActivity(LoginActivity::class.java)
                        progress.dismiss()
                    }

                    State.ERROR -> {
                        progress.dismiss()
                        showZenConfirmDialog("Oops..", it.message.defaultError())
                    }

                    State.LOADING -> {
                        progress.show()
                    }
                }
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
            return when {
                edtName.isEmpty() -> false
                edtEmail.isEmpty() -> false
                edtPassword.isEmpty() -> false
                edtPasswordconfirm.isEmpty() -> false
                else -> {
                    true
                }
            }
        }
    }
}