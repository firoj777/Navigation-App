package com.example.navigationapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var actionDrawerToggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottomBar.setupWithNavController(navController)

        actionDrawerToggle = ActionBarDrawerToggle(this, binding.drawerlayout, R.string.nav_open, R.string.nav_close)
        actionDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
               R.id.cetegoryFragment->{
                   binding.drawerNav.setupWithNavController(navController)
               }
                R.id.profileFragment->{
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.dark->{
                Toast.makeText(this,"Enable dark theme",Toast.LENGTH_SHORT).show()
                }
                R.id.light->{
                Toast.makeText(this,"Enable light theme",Toast.LENGTH_SHORT).show()
                }
                R.id.logout->{
                Toast.makeText(this,"You Are logout",Toast.LENGTH_SHORT).show()
                }

            }
            true
        }


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}