package com.example.otherapp_20220222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.otherapp_20220222.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var mStoreData: StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        mStoreData = intent.getSerializableExtra("store") as StoreData
        setupEvants()
        setValues()
    }

    fun setupEvants(){

        Glide.with(this).load(mStoreData.logoImageUrl).into(imgLogo)

        txtStoreName.text = mStoreData.name

        txtPhonNum.text = mStoreData.phonNum

        ratingBar.rating = mStoreData.rating.toFloat()

        txtRating.text = "(${mStoreData.rating})"

    }
    fun setValues(){

    }
}