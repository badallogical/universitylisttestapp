package com.example.universitylist.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.universitylist.network.University

class DetailViewModel( university: University ) : ViewModel(){

    private val _selected_university = MutableLiveData<University>()
    val selected_university : LiveData<University>
        get() = _selected_university

    init{
        _selected_university.value = university
    }

}