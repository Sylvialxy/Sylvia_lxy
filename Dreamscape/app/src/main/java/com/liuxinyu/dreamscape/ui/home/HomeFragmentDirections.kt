package com.liuxinyu.dreamscape.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.liuxinyu.dreamscape.R

class HomeFragmentDirections private constructor() {
    companion object {
        fun actionHomeFragmentToLoginFragment(): NavDirections {
            return ActionOnlyNavDirections(R.id.action_homeFragment_to_loginFragment)
        }
    }
}