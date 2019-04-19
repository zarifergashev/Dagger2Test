package com.example.dagger2test.commons

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast


fun Context.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.showSnackbar(message: String) {
    this.showSnackbar(message, null)
}

fun View.showSnackbar(message: String, listener: View.OnClickListener?) {
    Snackbar.make(this, "This is main activity", Snackbar.LENGTH_LONG)
        .setAction("CLOSE", listener)
        .setActionTextColor(this.getColor(android.R.color.holo_red_light))
        .show()
}


fun View.getColor(res: Int) = ContextCompat.getColor(this.context, res)