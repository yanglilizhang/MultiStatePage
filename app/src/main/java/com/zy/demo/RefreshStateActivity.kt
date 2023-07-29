package com.zy.demo

import androidx.lifecycle.lifecycleScope
import com.zy.demo.base.BaseActivity
import com.zy.demo.databinding.ActivityRefreshStateBinding
import com.zy.multistatepage.bindMultiState
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RefreshStateActivity : BaseActivity<ActivityRefreshStateBinding>() {
    private var count = 0
    override fun initPage() {
        val multiStateActivityRoot = bindMultiState()

        lifecycleScope.launch {
            multiStateActivityRoot.show<LoadingState>()
            delay(2000)
            val errorState = ErrorState()
            errorState.retry {
                lifecycleScope.launch {
                    multiStateActivityRoot.show<LoadingState>()
                    delay(2000)
                    multiStateActivityRoot.show(errorState) {
                        it.setErrorMsg("鸡你太美 ${++count}")
                        it.setErrorIcon(R.mipmap.jntm)
                    }
                }
            }
            multiStateActivityRoot.show(errorState)
        }
    }

}