package com.android.imdb.data.source

interface APIResponse<Type> {

    fun onSuccess(result: Type?)

    fun onError(t: Throwable)
}
