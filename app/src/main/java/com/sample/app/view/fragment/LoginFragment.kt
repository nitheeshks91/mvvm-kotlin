package com.sample.app.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.app.R
import com.sample.app.data.remote.response.ApiResponse
import com.sample.app.databinding.FragmentLoginBinding
import com.sample.app.di.Injectable
import com.sample.app.domain.model.User
import com.sample.app.utils.FragmentAnimation
import com.sample.app.utils.FragmentUtils
import com.sample.app.viewmodel.LoginViewModel
import javax.inject.Inject

/**
 * Login fragment
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
class LoginFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel

        viewModel.response.observe(this, Observer<ApiResponse<User>> { response ->
            activity?.let {
                FragmentUtils.replaceFragment(it as AppCompatActivity, ChangePasswordFragment(), R.id.fragmentContainer, false, FragmentAnimation.TRANSITION_NONE)
            }
        })
    }
}