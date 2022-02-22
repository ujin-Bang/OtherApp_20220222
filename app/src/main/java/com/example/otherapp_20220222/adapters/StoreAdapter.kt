package com.example.otherapp_20220222.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.otherapp_20220222.R
import com.example.otherapp_20220222.datas.StoreData
import com.willy.ratingbar.ScaleRatingBar

class StoreAdapter(
    val mContext: Context,
    resId: Int,
   val mList : ArrayList<StoreData>

): ArrayAdapter<StoreData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null) {

            tempRow = LayoutInflater.from(mContext).inflate(R.layout.store_list_item, null)
        }
        val row = tempRow!!

        val data = mList[position]

        val imgLogo = row.findViewById<ImageView>(R.id.imgLogo)
        val txtStoreName =row.findViewById<TextView>(R.id.txtStoreName)
        val ratingBar = row.findViewById<ScaleRatingBar>(R.id.ratingBar)

        txtStoreName.text = data.name
        return row
    }
}