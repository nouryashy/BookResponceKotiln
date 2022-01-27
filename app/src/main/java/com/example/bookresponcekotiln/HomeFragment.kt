package com.example.bookresponcekotiln

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {


    var bookViewModel: BookViewModel? = null
    var bookList = ArrayList<BookModel>()
    var bookModel: BookModel? = null

    var bookRecycle: RecyclerView? = null
    var bookAdapter: BookAdapter? = null

    var retrofitClient = RetrofitClient()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)


//        intRxList()

//        intCallBack()

        intCoroutine()
    }


//    private fun intCallBack() {
//        bookRecycle = posts_recycle_view
//        bookRecycle!!.layoutManager = LinearLayoutManager(context)
//        bookAdapter = BookAdapter(requireContext())
//        bookRecycle!!.adapter = bookAdapter
//        retrofitClient.getApi()!!.getPosts().enqueue(object : Callback<List<BookModel>> {
//            override fun onResponse(
//                call: Call<List<BookModel>>,
//                response: Response<List<BookModel>>
//            ) {
//                if (response.isSuccessful) {
//                    val bookList: List<BookModel> = response.body()!!
//                    bookAdapter!!.setList(bookList)
//                } else {
//                }
//            }
//
//            override fun onFailure(call: Call<List<BookModel>>, t: Throwable) {}
//        })
//    }


    // function for   rxjava call

//    private fun intRxList() {
//    bookAdapter = BookAdapter(requireContext())
//        bookViewModel!!.getAllPosts()
//            .observe(viewLifecycleOwner, object : Observer<List<BookModel>> {
//                override fun onChanged(postModels: List<BookModel>) {
//                    bookAdapter!!.setList(postModels)
//                }
//            })
//        bookRecycle = posts_recycle_view
//        bookRecycle!!.layoutManager = LinearLayoutManager(context)
//        bookRecycle!!.adapter = bookAdapter
//    }





   // function for   Coroutine call

    private fun intCoroutine() {
        bookRecycle = posts_recycle_view
        bookRecycle!!.layoutManager = LinearLayoutManager(context)
        bookAdapter = BookAdapter(requireContext())
        bookRecycle!!.adapter = bookAdapter
        // Create Service
        val service = retrofitClient.getApi()
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service!!.getEmployees()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val postList: List<BookModel> = response.body()!!
                    bookAdapter!!.setList(postList)


                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }

}