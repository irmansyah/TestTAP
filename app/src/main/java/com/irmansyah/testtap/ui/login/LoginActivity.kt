package com.irmansyah.testtap.ui.login

import android.content.Intent
import android.os.Bundle
import com.irmansyah.testtap.R
import com.irmansyah.testtap.ui.base.BaseActivity
import com.irmansyah.testtap.ui.reg.RegActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity(), LoginView {

    val presenter : LoginPresenter<LoginView> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)

        link_signup.setOnClickListener {
            startActivity(Intent(applicationContext, RegActivity::class.java))
        }
    }

    override fun showProgress() { }

    override fun hideProgress() { }
}
