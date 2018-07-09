package com.sample.app.utils.view

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.widget.LinearLayout
import com.sample.app.R

/**
 * Page Step indicator view
 * Author: Nitheesh KS
 * Company: Farabi Technologies
 * Email: nitheesh@farabi.ae
 * Created: 7/9/2018
 * Modified: 7/9/2018
 */
class StepperIndicator : LinearLayout {

    init {
        orientation = LinearLayout.HORIZONTAL
    }

    constructor(context: Context) : super(context) {
        orientation = LinearLayout.HORIZONTAL
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        orientation = LinearLayout.HORIZONTAL
    }

    fun setStepPosition(currentStep: Int, totalSteps: Int) {
        removeAllViews()
        var i = 0
        while (i < totalSteps) {

            val view = AppCompatImageView(this.context)
            val layoutParams = LinearLayout.LayoutParams(20, 20)
            if (i != 0)
                layoutParams.setMargins(20, 0, 0, 0)
            view.layoutParams = layoutParams

            if (i < currentStep)
                view.setBackgroundResource(R.drawable.page_indicator_selected)
            else
                view.setBackgroundResource(R.drawable.page_indicator_unselected)

            this.addView(view)
            i++
        }
    }
}

