package com.zy.demo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.zy.multistatepage.MultiState
import com.zy.multistatepage.MultiStateContainer
import java.lang.reflect.ParameterizedType

/**
 * @author: yanz
 */
abstract class MultiStateBinding<VB : ViewBinding> : MultiState() {

    lateinit var viewBinding: VB

    override fun onCreateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val clazz = parameterizedType.actualTypeArguments[0] as Class<*>
        val inflate = clazz.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        viewBinding = inflate.invoke(null, inflate, container, false) as VB
        return viewBinding.root
    }

    override fun onViewCreated(view: View) {
        onMultiStateViewCreate()
    }

    abstract fun onMultiStateViewCreate()
}