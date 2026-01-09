package com.example.navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
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

        tbToolbar.setNavigationOnClickListener{
            if(dlMain.isDrawerOpen(GravityCompat.START)){
                dlMain.closeDrawer(GravityCompat.START)
            }  else{
                dlMain.openDrawer(GravityCompat.START)
            }
        }

    }
}