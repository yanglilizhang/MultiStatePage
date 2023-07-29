package com.zy.demo.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * @author: yanz
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    lateinit var viewBinding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBindingForActivity(layoutInflater)
        setContentView(viewBinding.root)
        initPage()
    }

    abstract fun initPage()

    @Suppress("UNCHECKED_CAST")
    private fun getViewBindingForActivity(layoutInflater: LayoutInflater): VB {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }

}