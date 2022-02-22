package com.example.otherapp_20220222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.otherapp_20220222.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    fun setupEvents(){

    }

    fun setValues(){

        mAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mAdapter

        mainTabLayout.setupWithViewPager(mainViewPager)

    }


}