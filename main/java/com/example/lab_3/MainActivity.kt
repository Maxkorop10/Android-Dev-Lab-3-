package com.example.lab_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.sampledata.AuthorData
import com.example.lab_3.sampledata.LibraryData

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val LibraryList = listOf(
            LibraryData("The Great Gatsby", "1925"),
            AuthorData("F. Scott Fitzgerald", "US"),

            LibraryData("1984", "1949"),
            AuthorData("George Orwell", "UK"),

            LibraryData("Pride and Prejudice", "1813"),
            AuthorData("Jane Austen", "UK"),


            LibraryData("The Catcher in the Rye",  "1951"),
            AuthorData("J.D. Salinger", "US"),

            LibraryData("Harry Potter", "1961"),
            AuthorData("Rowling", "UK"),

            LibraryData("Moby Dick", "1851"),
            AuthorData("Herman Melville", "US"),

            LibraryData("War and Peace", "1869"),
            AuthorData("Leo Tolstoy", "Russian Empire")
        )

        val adapter = Adapter(LibraryList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
