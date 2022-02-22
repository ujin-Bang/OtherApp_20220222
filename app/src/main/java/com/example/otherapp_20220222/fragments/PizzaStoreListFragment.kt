package com.example.otherapp_20220222.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.otherapp_20220222.R
import com.example.otherapp_20220222.ViewStoreDetailActivity
import com.example.otherapp_20220222.adapters.StoreAdapter
import com.example.otherapp_20220222.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

class PizzaStoreListFragment: Fragment() {

    val mPizzaStoreList = ArrayList<StoreData>()
    lateinit var mPizzaStoreAdapter: StoreAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()

//        피자가게 리스트뷰의 동작 코드
    }

    fun setupEvents(){

        pizzaStoreListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedStore = mPizzaStoreList[position]

            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("store",clickedStore)
            startActivity(myIntent)
        }
    }
    fun setValues(){

        mPizzaStoreList.add( StoreData("피자헛",4.5,"1588-5588"," https://cdn.dailycnc.com/news/photo/201708/73884_178465_218.jpg"))
        mPizzaStoreList.add( StoreData("파파존스", 3.5, "1577-8080","http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        mPizzaStoreList.add( StoreData("도미노피자",5.0,"1577-3082","https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))
        mPizzaStoreList.add( StoreData("미스터피자",4.toDouble(), "1577-0077"," https://image.newdaily.co.kr/site/data/img/2021/12/08/2021120800064_0.jpg"))

        mPizzaStoreAdapter = StoreAdapter(requireContext(), R.layout.store_list_item, mPizzaStoreList)
        pizzaStoreListView.adapter = mPizzaStoreAdapter
    }

}