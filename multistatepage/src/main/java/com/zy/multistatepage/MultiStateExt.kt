package com.zy.multistatepage

import android.app.Activity
import android.view.View

/**
 * @author: yanz
 */
fun View.bindMultiState() = MultiStatePage.bindMultiState(this)

fun Activity.bindMultiState() = MultiStatePage.bindMultiState(this)