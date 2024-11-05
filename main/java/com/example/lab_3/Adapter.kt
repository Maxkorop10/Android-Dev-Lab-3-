package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.sampledata.AuthorData
import com.example.lab_3.sampledata.InterfaceItem
import com.example.lab_3.sampledata.LibraryData

class Adapter(private val dataList: List<InterfaceItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val prodYearTextView: TextView = itemView.findViewById(R.id.prodYearTextView)
    }

    inner class AuthorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val author_FullName: TextView = view.findViewById(R.id.author_FullName)
        val homeCountry: TextView = view.findViewById(R.id.homeCountry)
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].getItemType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            InterfaceItem.librarydata -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.book_layout, parent, false)
                BookViewHolder(view)
            }
            InterfaceItem.authordata -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.author_layout, parent, false)
                AuthorViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = dataList[position]) {
            is LibraryData -> {
                val bookHolder = holder as BookViewHolder
                bookHolder.titleTextView.text = item.title
                bookHolder.prodYearTextView.text = item.prod_year
            }
            is AuthorData -> {
                val authorHolder = holder as AuthorViewHolder
                authorHolder.author_FullName.text = item.full_name
                authorHolder.homeCountry.text = item.homecountry
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
