package com.example.lab_3.sampledata

data class AuthorData(
    val full_name: String,
    val homecountry: String
) : InterfaceItem {
    override fun getItemType(): Int {
        return InterfaceItem.authordata
    }
}
