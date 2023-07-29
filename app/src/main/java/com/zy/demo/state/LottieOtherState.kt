package com.zy.demo.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zy.demo.R
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer

/**
 * @author: yanz
 */
class LottieOtherState : MultiState() {

    var retry: (() -> Unit)? = null

    override fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return inflater.inflate(R.layout.multi_lottie_other, container, false)
    }

    override fun onViewCreate(view: View) {
        view.findViewById<View>(R.id.view).setOnClickListener { retry?.invoke() }
    }

}