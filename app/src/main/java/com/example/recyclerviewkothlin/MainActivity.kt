package com.example.recyclerviewkothlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() , ExampleItemAdapter.OnItemClickListener {

    var list = ArrayList<ExampleItem>()
    var adapter=ExampleItemAdapter(list,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = getExampleItems(20);
        adapter=ExampleItemAdapter(list,this)
        recycler_view.layoutManager = LinearLayoutManager(this);
        recycler_view.adapter = adapter

    }

    private fun getExampleItems(size: Int): ArrayList<ExampleItem> {

        val items = ArrayList<ExampleItem>();

        for (i in 0 until size) {

            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_account_circle
                else -> R.drawable.ic_favorite
            }
            val item = ExampleItem(drawable, "Item $i", "Line2")
            items.add(item)
        }
        return items

    }

     fun insertItem(view:View){

        val index = Random.nextInt(8)
        list.add(ExampleItem(R.drawable.ic_favorite,"New item added at position $index","line 2"))
        adapter.notifyDataSetChanged()
    }

     fun removeItem(view:View){
         val index = Random.nextInt(8)
         list.removeAt(index)
         adapter.notifyDataSetChanged()

    }

    override fun onItemClick(position: Int) {
        Log.i("srt","onItemClick")
        val clickedItem = list[position]
        clickedItem.text2 = "Item $position is clicked";
        adapter.notifyDataSetChanged()

    }

    override fun onIconClick(position: Int) {
        Log.i("srt","onIconClick")
        val clickedItem =list[position]
        list.removeAt(position)
        adapter.notifyDataSetChanged()

    }

}
