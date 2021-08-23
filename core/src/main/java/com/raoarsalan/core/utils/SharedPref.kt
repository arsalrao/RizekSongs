package com.raoarsalan.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.raoarsalan.core.common.SharedPrefConstants
import com.raoarsalan.core.utils.PrefUtil.set


class SharedPref constructor(context: Context) {

    private var sharedPreferences: SharedPreferences =
        PrefUtil.customPrefs(context, SharedPrefConstants.APP_PREFS)

    fun getToken(): String? {
        return sharedPreferences.getString(SharedPrefConstants.TOKEN, null)
    }

    fun setToken(token: String?) {
        sharedPreferences[SharedPrefConstants.TOKEN] = token
    }


    fun getTokenType(): String? {
        return sharedPreferences.getString(SharedPrefConstants.TOKEN_TYPE, null)
    }

    fun setTokenType(token: String?) {
        sharedPreferences.set(SharedPrefConstants.TOKEN_TYPE, token)

    }


}