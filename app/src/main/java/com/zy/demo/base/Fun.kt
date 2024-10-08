package com.zy.demo.base

import android.app.Activity
import android.content.Intent
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.state.EmptyState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import com.zy.multistatepage.state.SuccessState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author: yanz
 */
fun mockRandom(multiStateContainer: MultiStateContainer, block: () -> Unit) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        block.invoke()
        when ((1..3).random()) {
            1 -> multiStateContainer.show<SuccessState>()
            2 -> multiStateContainer.show<EmptyState>()
            3 -> multiStateContainer.show<ErrorState>()
        }
    }
}

fun mockError(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
//        val errorState = ErrorState()
//        errorState.retry { mockSuccess(multiStateContainer) }
        multiStateContainer.show<ErrorState> {
            it.retry { mockSuccess(multiStateContainer) }
        }
    }
}

fun mockSuccess(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        multiStateContainer.show<SuccessState>()
    }
}

fun mockEmpty(multiStateContainer: MultiStateContainer) {
    MainScope().launch {
        multiStateContainer.show<LoadingState>()
        val delayTime = (10..30).random() * 100.toLong()
        delay(delayTime)
        multiStateContainer.show<EmptyState>()
    }
}

fun MultiStateContainer.showSuccess(callBack: () -> Unit = {}) {
    show<SuccessState> {
        callBack.invoke()
    }
}

fun MultiStateContainer.showError(callBack: (ErrorState) -> Unit = {}) {
    show<ErrorState> {
        callBack.invoke(it)
    }
}

fun MultiStateContainer.showEmpty(callBack: () -> Unit = {}) {
    show<EmptyState> {
        callBack.invoke()
    }
}

fun MultiStateContainer.showLoading(callBack: () -> Unit = {}) {
    show<LoadingState> {
        callBack.invoke()
    }
}

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}
