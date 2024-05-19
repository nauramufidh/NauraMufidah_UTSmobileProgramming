package com.example.utsmobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapterfragment2(private val context: Context, private val dataSource: List<NewsData>): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.item_fragment2, parent, false)
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.newsImageView) as ImageView
            holder.titleTextView = view.findViewById(R.id.newsTitleTextView) as TextView
            holder.descriptionTextView = view.findViewById(R.id.newsDescriptionTextView) as TextView
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val newsData = getItem(position) as NewsData

        holder.thumbnailImageView.setImageResource(newsData.imageResId)
        holder.titleTextView.text = newsData.title
        holder.descriptionTextView.text = newsData.shortDescription

        return view
    }

    private class ViewHolder {
        lateinit var thumbnailImageView: ImageView
        lateinit var titleTextView: TextView
        lateinit var descriptionTextView: TextView
    }
}
