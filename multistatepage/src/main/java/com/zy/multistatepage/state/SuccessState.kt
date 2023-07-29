package com.zy.multistatepage.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.R

/**
 * @author: yanz
 */
class SuccessState : MultiState() {
    override fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return View(context)
    }

    override fun onViewCreated(view: View) = Unit

}