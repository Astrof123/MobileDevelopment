package com.example.testnew

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.flexbox.FlexboxLayout

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    private var currentFragment = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        showFragment(FirstFragment())

        val fragment_container: FrameLayout = findViewById(R.id.fragment_container)

        fragment_container.setOnClickListener {
            if (currentFragment == 1) {
                currentFragment = 2
                showFragment(SecondFragment())
            }
            else {
                currentFragment = 1
                showFragment(FirstFragment())
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}