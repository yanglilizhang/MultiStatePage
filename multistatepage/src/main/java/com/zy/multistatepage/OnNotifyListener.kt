package com.zy.multistatepage

/**
 * @author: yanz
 */
fun interface OnNotifyListener<T : MultiState> {
    fun onNotify(multiState: T)
}