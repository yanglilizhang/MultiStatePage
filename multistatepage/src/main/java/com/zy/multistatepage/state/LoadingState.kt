package com.zy.multistatepage.state

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.MultiStatePage
import com.zy.multistatepage.R

/**
 * @author: yanz
 */
class LoadingState : MultiState() {
    private lateinit var tvLoadingMsg: TextView
    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer,
    ): View {
        return inflater.inflate(R.layout.mult_state_loading, container, false)
    }

    override fun onMultiStateViewCreate(view: View) {
        tvLoadingMsg = view.findViewById(R.id.tv_loading_msg)
        setLoadingMsg(MultiStatePage.config.loadingMsg)
    }

    override fun onMultiStateViewHiddenChanged(hide: Boolean) {
        super.onMultiStateViewHiddenChanged(hide)
        if (hide) {
            Log.e("TAG", "LoadingState: 隐藏了")
        } else {
            Log.e("TAG", "LoadingState: 显示了")
        }
    }

    fun setLoadingMsg(loadingMsg: String) {
        tvLoadingMsg.text = loadingMsg
    }
}