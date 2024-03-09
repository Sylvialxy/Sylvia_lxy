package com.liuxinyu.dreamscape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.liuxinyu.dreamscape.databinding.ActivityMainBinding
import com.liuxinyu.dreamscape.ui.clock.ClockFragment
import com.liuxinyu.dreamscape.ui.history.HistoryFragment
import com.liuxinyu.dreamscape.ui.settings.SettingsFragment
import com.liuxinyu.dreamscape.ui.today.TodayFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigationView()
        navController.navigate(R.id.homeFragment)
        navigateToToday()
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_today -> {
                    navigateToFragment(TodayFragment())
                    true
                }
                R.id.nav_clock -> {
                    navigateToFragment(ClockFragment())
                    true
                }
                R.id.nav_history -> {
                    navigateToFragment(HistoryFragment())
                    true
                }
                R.id.nav_settings -> {
                    navigateToFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun navigateToToday() {
        navigateToFragment(TodayFragment())
    }
}