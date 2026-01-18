package com.example.navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var dlMain: DrawerLayout
    private lateinit var nvMain: NavigationView
    private lateinit var tbToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dlMain = findViewById(R.id.dlMain)
        nvMain = findViewById(R.id.nvMain)
        tbToolbar = findViewById(R.id.tbToolbar)

        // Default Fragment
        loadFragment(MyAccountFragment())

        tbToolbar.setNavigationOnClickListener {
            if (dlMain.isDrawerOpen(GravityCompat.START)) {
                dlMain.closeDrawer(GravityCompat.START)
            } else {
                dlMain.openDrawer(GravityCompat.START)
            }
        }

        nvMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mitem_account -> loadFragment(MyAccountFragment())
                R.id.mitem_setting -> loadFragment(SettingsFragment())
                R.id.mitem_logout -> finish()
            }
            dlMain.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
