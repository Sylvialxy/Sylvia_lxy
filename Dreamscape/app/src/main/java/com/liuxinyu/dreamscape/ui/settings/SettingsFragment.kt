package com.liuxinyu.dreamscape.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.liuxinyu.dreamscape.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置菜单项点击监听器
        val menuItem1: TextView = view.findViewById(R.id.menuItem1Text)
        /*val menuItem2: TextView = view.findViewById(R.id.menuItem2)
        val menuItem3: TextView = view.findViewById(R.id.menuItem3)
        val menuItem4: TextView = view.findViewById(R.id.menuItem4)
        val menuItem5: TextView = view.findViewById(R.id.menuItem5)
        val menuItem6: TextView = view.findViewById(R.id.menuItem6)*/

        menuItem1.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_myFragment1)
        }

        /* menuItem2.setOnClickListener {
             findNavController().navigate(R.id.action_settingsFragment_to_yourFragment2)
         }

         menuItem3.setOnClickListener {
             findNavController().navigate(R.id.action_settingsFragment_to_yourFragment3)
         }

         menuItem4.setOnClickListener {
             findNavController().navigate(R.id.action_settingsFragment_to_yourFragment4)
         }

         menuItem5.setOnClickListener {
             findNavController().navigate(R.id.action_settingsFragment_to_yourFragment5)
         }

         menuItem6.setOnClickListener {
             findNavController().navigate(R.id.action_settingsFragment_to_yourFragment6)
         }*/

    }


}