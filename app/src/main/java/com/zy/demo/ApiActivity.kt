package com.zy.demo

import android.widget.Toast
import com.zy.demo.databinding.ActivityApiBinding
import com.zy.demo.state.LottieWaitingState
import com.zy.demo.base.BaseActivity
import com.zy.demo.state.LottieOtherState
import com.zy.multistatepage.bindMultiState
import com.zy.multistatepage.state.*

class ApiActivity : BaseActivity<ActivityApiBinding>() {
    override fun initPage() {

        val multiState = viewBinding.fl.bindMultiState()

        viewBinding.btnLoading.setOnClickListener {
            multiState.show<LoadingState>()
        }

        viewBinding.btnSuccess.setOnClickListener {
            multiState.show<SuccessState>()
        }

        viewBinding.btnEmpty.setOnClickListener {
            multiState.show<EmptyState>()
        }

        viewBinding.btnError.setOnClickListener {
            multiState.show<ErrorState>()
        }

        viewBinding.btnLottie1.setOnClickListener {
            multiState.show<LottieWaitingState>()
        }

        val lottieOtherState = LottieOtherState()
        viewBinding.btnLottie2.setOnClickListener {
            lottieOtherState.retry = {
                Toast.makeText(this, "retry...", Toast.LENGTH_SHORT).show()
            }
            multiState.show(lottieOtherState)
        }
    }
}