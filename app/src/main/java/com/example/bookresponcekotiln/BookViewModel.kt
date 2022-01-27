package com.example.bookresponcekotiln

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val postRepository = BookRepository(application)

   fun getAllPosts ():LiveData<List<BookModel>>{
       return postRepository.getAllPro()
   }


}