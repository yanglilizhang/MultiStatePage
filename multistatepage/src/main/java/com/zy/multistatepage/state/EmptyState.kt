package com.zy.multistatepage.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.MultiStatePage
import com.zy.multistatepage.R

/**
 * @author: yanz
 */
class EmptyState : MultiState() {

    private lateinit var tvEmptyMsg: TextView
    private lateinit var imgEmpty: ImageView

    override fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return inflater.inflate(R.layout.mult_state_empty, container, false)
    }

    override fun onViewCreate(view: View) {
        tvEmptyMsg = view.findViewById(R.id.tv_empty_msg)
        imgEmpty = view.findViewById(R.id.img_empty)

        setEmptyMsg(MultiStatePage.config.emptyMsg)
        setEmptyIcon(MultiStatePage.config.emptyIcon)
    }

    fun setEmptyMsg(emptyMsg: String) {
        tvEmptyMsg.text = emptyMsg
    }

    fun setEmptyIcon(@DrawableRes emptyIcon: Int) {
        imgEmpty.setImageResource(emptyIcon)
    }
}