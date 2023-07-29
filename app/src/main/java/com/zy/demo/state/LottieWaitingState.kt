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
class LottieWaitingState : MultiState() {
    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer,
    ): View {
        return inflater.inflate(R.layout.multi_lottie_waiting, container, false)
    }

    override fun onMultiStateViewCreate(view: View) {
    }

}