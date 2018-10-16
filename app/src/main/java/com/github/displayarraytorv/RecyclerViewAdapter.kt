package com.github.displayarraytorv

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/16/2018
 *  check https://github.com/KeiLazu for more
 */
class RecyclerViewAdapter (private val context: Context, private val items: List<Item>,
                           private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            items.image?.let {
                Picasso.get().load(it).resize(50,50).into(image)
                /**
                 * Dev Notes:
                 * I download the oversize one from github so i'll add "resize" this into 50x50
                 */
            }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}