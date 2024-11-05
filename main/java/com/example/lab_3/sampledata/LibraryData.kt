package com.example.lab_3.sampledata

data class LibraryData(
    val title: String,
    val prod_year: String
) : InterfaceItem {
    override fun getItemType(): Int {
        return InterfaceItem.librarydata
    }
}
