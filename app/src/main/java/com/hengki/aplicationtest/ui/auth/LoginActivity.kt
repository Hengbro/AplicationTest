package com.hengki.aplicationtest.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hengki.aplicationtest.core.source.model.User
import com.hengki.aplicationtest.core.source.remote.request.LoginRequest
import com.hengki.aplicationtest.core.source.remote.network.State
import com.hengki.aplicationtest.util.Constants.EMAIL
import com.hengki.aplicationtest.databinding.ActivityLoginBinding
import com.hengki.aplicationtest.ui.base.MyActivity
import com.hengki.aplicationtest.ui.product.ListProductActivity
import com.hengki.aplicationtest.util.defaultError
import com.hengki.aplicationtest.util.recallKoin
import com.inyongtisto.myhelper.extension.isEmpty
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.toastError
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : MyActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var typeLogin = EMAIL

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun mainButton(){
        binding.apply {
            btnLogin.setOnClickListener {
                if (validate()) {
                    val user = LoginRequest(
                        email = edtEmail.text.toString(),
                        password = edtPassword.text.toString(),
                    )

                    typeLogin = EMAIL
                    login(user)
                }
            }
        }
    }

    private fun login(user: LoginRequest) {
        viewModel.login(user).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    recallKoin()
                    onSuccess(it.body)
                }

                State.ERROR -> {
                    progress.dismiss()
                    binding.apply {
                        when (it.message) {
                            "Email tidak terdaftar" -> {
                                edtEmail.error = "Email tidak terdaftar"
                                edtEmail.requestFocus()
                            }

                            "Password Salah" -> {
                                edtPassword.error = "Password Salah"
                                edtPassword.requestFocus()
                            }

                            else -> {
                                toastError(it.message.defaultError())
                            }
                        }
                    }
                }

                State.LOADING -> {
                    progress.show()
                }
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
            return when {
                edtEmail.isEmpty() -> false
                edtPassword.isEmpty() -> false
                else -> {
                    true
                }
            }
        }
    }

    private fun onSuccess(user: User?) {
        toMainActivity()
    }

    private fun toMainActivity() {
        pushActivity(ListProductActivity::class.java)
    }

}