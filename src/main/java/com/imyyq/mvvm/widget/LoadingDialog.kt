package com.imyyq.mvvm.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.annotation.LayoutRes
import com.imyyq.mvvm.R
import com.imyyq.mvvm.app.GlobalConfig

class LoadingDialog(
    context: Context,
    @LayoutRes private val mLayoutRes: Int,
    cancelable: Boolean = GlobalConfig.loadingDialogCancelable,
    canceledOnTouchOutside: Boolean = GlobalConfig.loadingDialogCanceledOnTouchOutside
) : Dialog(context, R.style.BaseDialogStyle) {

    init {
        setCancelable(cancelable)
        setCanceledOnTouchOutside(canceledOnTouchOutside)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mLayoutRes)

        /*
         * 窗体默认包含View，不设置width会压缩View
         */
        window?.apply {
            val params = attributes
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.CENTER
            attributes = params
        }
    }
}