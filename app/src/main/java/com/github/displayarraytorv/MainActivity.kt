package com.github.displayarraytorv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/16/2018
 *  check https://github.com/KeiLazu for more
 */

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items) {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show() // i'll shorten this to make sure the codes is concise
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i,0)))
        }

        image.recycle()
    }

}
