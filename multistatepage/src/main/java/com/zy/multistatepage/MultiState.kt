package com.zy.multistatepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * @author: yanz
 */
abstract class MultiState {

    /**
     * 创建stateView
     */
    abstract fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer,
    ): View

    /**
     * stateView创建完成
     */
    abstract fun onViewCreated(view: View)


    open fun onHiddenChanged(hide: Boolean) {

    }
}