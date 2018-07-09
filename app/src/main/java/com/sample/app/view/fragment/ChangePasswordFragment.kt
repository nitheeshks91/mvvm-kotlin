package com.sample.app.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.app.R
import com.sample.app.databinding.FragmentChangePasswordBinding
import com.sample.app.di.Injectable
import com.sample.app.viewmodel.ChangePasswordViewModel
import kotlinx.android.synthetic.main.fragment_change_password.*
import javax.inject.Inject

/**
 * Change password fragment
 * Author: Nitheesh ks
 * Company: Farabi Technologies
 * Email: nitheesh@farabi.ae
 * Created: 7/8/2018
 * Modified: 7/8/2018
 */
class ChangePasswordFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: ChangePasswordViewModel

    private lateinit var binding: FragmentChangePasswordBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ChangePasswordViewModel::class.java)
        binding.viewModel = viewModel
        step_indicator.setStepPosition(1, 2)

        viewModel.backPress.observe(this, Observer<Boolean> { action ->
            if (action as Boolean)
                activity?.onBackPressed()
        })
    }
}