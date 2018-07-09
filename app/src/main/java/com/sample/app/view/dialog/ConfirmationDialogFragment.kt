package com.sample.app.view.dialog

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.sample.app.R
import com.sample.app.databinding.DialogConfirmationBinding
import com.sample.app.di.Injectable
import com.sample.app.viewmodel.ConfirmationDialogViewModel
import javax.inject.Inject

class ConfirmationDialogFragment : DialogFragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: ConfirmationDialogViewModel

    private lateinit var binding: DialogConfirmationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_confirmation, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ConfirmationDialogViewModel::class.java)
        binding.viewModel = viewModel

        observeButtonAction()
    }

    private fun observeButtonAction() {
        viewModel.positiveButtonClick.observe(this, Observer<Boolean> { action ->
            dismiss()
        })

        viewModel.negativeButtonClick.observe(this, Observer<Boolean> { action ->
            dismiss()
        })
    }

    override fun onResume() {
        dialog.window.setLayout(600, LinearLayout.LayoutParams.WRAP_CONTENT)
        super.onResume()
    }
}