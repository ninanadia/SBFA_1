package com

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUser(
    var name: String,
    var username: String,
    var location: String,
    var company: String,
    var followers: String,
    var following: String,
    var avatar: Int
) : Parcelable