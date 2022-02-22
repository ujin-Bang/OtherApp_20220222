package com.example.otherapp_20220222

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.otherapp_20220222.datas.StoreData
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

        val pl = object : PermissionListener {
            override fun onPermissionGranted() {

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ViewStoreDetailActivity, "통화 권한이 없습니다.", Toast.LENGTH_SHORT)
                    .show()
            }


        }

       btnCall.setOnClickListener {

        TedPermission.create()
            .setPermissionListener(pl)
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()

       }

    }
    fun setValues(){
        Glide.with(this).load(mStoreData.logoImageUrl).into(imgLogo)

        txtStoreName.text = mStoreData.name

        txtPhonNum.text = mStoreData.phonNum

        ratingBar.rating = mStoreData.rating.toFloat()

        txtRating.text = "(${mStoreData.rating})"

    }
}