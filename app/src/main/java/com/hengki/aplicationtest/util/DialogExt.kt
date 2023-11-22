package com.hengki.aplicationtest.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.extension.percentageDialog
import com.inyongtisto.myhelper.util.ConfirmDialogFragment


fun AppCompatActivity.showZenConfirmDialog(
    title: String,
    subtitle: String,
    actionText: String = "Ok",
    actionTextSecondary: String? = null,
    cancellable: Boolean = true,
    percentage: Int? = null,
    onActionSecondary: (() -> Unit)? = null,
    onAction: (() -> Unit)? = null) {
    val mPercentage = percentage ?: percentageDialog()
    ConfirmDialogFragment(title, subtitle, actionText, actionTextSecondary, cancellable, mPercentage, onActionSecondary, onAction).show(supportFragmentManager, ConfirmDialogFragment.TAG)
}

fun Fragment.showZenConfirmDialog(
    title: String,
    subtitle: String,
    actionText: String = "Ok",
    actionTextSecondary: String? = null,
    cancellable: Boolean = true,
    percentage: Int? = null,
    onActionSecondary: (() -> Unit)? = null,
    onAction: (() -> Unit)? = null) {
    val mPercentage = percentage ?: requireActivity().percentageDialog()
    ConfirmDialogFragment(title, subtitle, actionText, actionTextSecondary, cancellable, mPercentage, onActionSecondary, onAction).show(childFragmentManager, ConfirmDialogFragment.TAG)
}