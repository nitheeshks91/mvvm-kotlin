package com.sample.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.sample.app.utils.FragmentAnimation
import com.sample.app.utils.FragmentUtils
import com.sample.app.view.fragment.LoginFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Prelogin activity
 * Author: Lajesh D
 * Company: Farabi Technologies
 * Email: Lajesh@farabi.ae
 * Created: 7/1/2018
 * Modified: 7/1/2018
 */
class PreLoginActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Primary)
        setContentView(R.layout.activity_main)
        FragmentUtils.replaceFragment(this, LoginFragment(), R.id.fragmentContainer, false, FragmentAnimation.TRANSITION_NONE)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
