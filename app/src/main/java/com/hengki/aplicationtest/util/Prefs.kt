package com.hengki.aplicationtest.util

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {
    var isLogin by booleanPref(false)
    var token by nullableStringPref()
}