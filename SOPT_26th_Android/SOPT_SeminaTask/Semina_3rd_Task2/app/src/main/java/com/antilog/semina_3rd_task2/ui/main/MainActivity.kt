package com.antilog.semina_3rd_task2.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.antilog.semina_3rd_task2.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        //App Compact Toolbar 인스턴스 얻기
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Status Bar 높이만큼 Padding 부여
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        setViewPager()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> viewpager.currentItem = 0
                R.id.menu_book -> viewpager.currentItem = 1
                R.id.menu_person -> viewpager.currentItem = 2
            }
            true
        }
    }

    //set ViewPager
    private fun setViewPager(){
        viewpager.adapter = MainPagerAdapter(supportFragmentManager)
        viewpager.offscreenPageLimit = 2
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) =Unit

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }

        })
    }

    //status bar 높이 계산
    private fun getStatusBarHeight(): Int {
        var result = 0
        var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}

