package com.codebox.kidslab.framework.SupportVersion

import android.os.Build

/**
 * Created by Abed on 2/3/2018.
 */
val EMPTY: (Throwable) -> Unit = {}
inline fun versionSupport(newerSDK:Int, newerSDKBlock:()-> Unit, olderSDKBlock:() -> Unit ){
    if (Build.VERSION.SDK_INT>= newerSDK) {
        if (newerSDKBlock === EMPTY) {
           throw Exception("Null Lambda Block")
        } else
            newerSDKBlock()
    }
    else
        if (newerSDKBlock === EMPTY) {
            throw Exception("Null Lambda Block")
        } else olderSDKBlock()
}
inline fun versionSupport(SDKVersion:Int, codeBlock:()-> Unit){
    if (Build.VERSION.SDK_INT>= SDKVersion) {
        codeBlock()
    }

}