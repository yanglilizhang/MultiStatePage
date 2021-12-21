package com.zy.demo

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.zy.demo.base.*
import com.zy.demo.databinding.ActivitySmartRefreshLayout2Binding
import com.zy.demo.databinding.ActivitySmartRefreshLayoutBinding
import com.zy.multistatepage.bindMultiState
import kotlinx.coroutines.delay

/**
 * @ProjectName: MultiStatePage
 * @Author: jojo
 * @Email: 17635289240@163.com
 * @CreateDate: 2021/8/2 5:48 下午
 * @Description: TODO
 */
class SmartRefreshLayoutActivity2 : BaseActivity<ActivitySmartRefreshLayout2Binding>() {
    private val rlvAdapter = SmartRefreshLayoutActivity.RlvAdapter()
    private val container by lazy { viewBinding.recyclerView.bindMultiState() }

    override fun initPage() {
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerView.adapter = rlvAdapter
        loadData()


        viewBinding.smartRefreshLayout.setEnableLoadMoreWhenContentNotFull(false)

        viewBinding.smartRefreshLayout.setOnRefreshListener {
            rlvAdapter.refreshData(getData(50))
            container.showSuccess()
            it.finishRefresh()
        }
        viewBinding.smartRefreshLayout.setOnLoadMoreListener {
            rlvAdapter.addData(getData(30))
            container.showSuccess()
            it.finishLoadMore()
        }

        viewBinding.btnContent.setOnClickListener {
            rlvAdapter.refreshData(getData(50))
            container.showSuccess()
        }
        viewBinding.btnError.setOnClickListener {
            rlvAdapter.clearData()
            container.showError() {
                it.retry { loadData() }
            }
        }
        viewBinding.btnEmpty.setOnClickListener {
            rlvAdapter.clearData()
            container.showEmpty()
        }
    }

    private fun loadData() {
        lifecycleScope.launchWhenResumed {
            container.showLoading()
            delay(3000)
            rlvAdapter.refreshData(getData(50))
            container.showSuccess()
        }
    }

    private fun getData(count: Int): MutableList<String> {
        val data = mutableListOf<String>()
        for (i in 0 until count) {
            data.add("data")
        }
        return data
    }
}