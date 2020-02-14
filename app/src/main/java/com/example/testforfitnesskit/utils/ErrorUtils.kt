package com.example.testforfitnesskit.utils

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorUtils {

    companion object{
        const val NETWORK_ERROR = "NETWORK_ERROR"
        const val ANY_ERROR = "ANY_ERROR"
        const val NONE = "NONE"

        fun whatError(throwable: Throwable): String{
            if(throwable is UnknownHostException ||
                throwable is SocketTimeoutException ||
                throwable is ConnectException
            ) return NETWORK_ERROR
            return ANY_ERROR
        }
    }
}