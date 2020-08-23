package com.android.imdb.utils

import android.content.Context
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


inline fun <reified T : Fragment> newFragmentInstance(vararg params: Pair<String, Any?>): T {
    return T::class.java.newInstance().apply {
        arguments = bundleOf(*params)
    }
}

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()