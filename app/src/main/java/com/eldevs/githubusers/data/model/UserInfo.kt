package com.eldevs.githubusers.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UserInfo(
    val avatar_url: String? = null,
    val bio: @RawValue Any?= null,
    val blog: String?= null,
    val company: String? = null,
    val created_at: String? = null,
    val email: @RawValue Any? = null,
    val events_url: String? = null,
    val followers: Int? = null,
    val followers_url: String? = null,
    val following: Int? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val gravatar_id: String? = null,
    val hireable: @RawValue Any? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val location: String? = null,
    val login: String? = null,
    val name: String? = null,
    val node_id: String? = null,
    val organizations_url: String? = null,
    val public_gists: Int? = null,
    val public_repos: Int? = null,
    val received_events_url: String? = null,
    val repos_url: String? = null,
    val site_admin: Boolean? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val twitter_username: String? = null,
    val type: String? = null,
    val updated_at: String? = null,
    val url: String? = null
) :Parcelable