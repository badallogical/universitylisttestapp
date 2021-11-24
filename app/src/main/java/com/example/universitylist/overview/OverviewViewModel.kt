package com.example.universitylist.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universitylist.network.University
import com.example.universitylist.network.UniversityApi
import kotlinx.coroutines.launch
import java.io.IOException

class OverviewViewModel : ViewModel() {

    private val _universities = MutableLiveData<List<University>>()

    val universities : LiveData<List<University>>
            get() = _universities

    init{
        getUniversities("india")
    }

    fun getUniversities( country : String ){
         viewModelScope.launch{
             try {
                 _universities.value = UniversityApi.retrofitService.getUniversity(country)

             }catch( exception : IOException ){
                 Log.d("overviewmodel", exception.message.toString() )
                 _universities.value = ArrayList()
             }
         }
    }


}