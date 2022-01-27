package com.example.bookresponcekotiln

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.posts_ver_item_list.view.*
import java.util.ArrayList

class BookAdapter(private val mContext: Context) :
    RecyclerView.Adapter<BookAdapter.PostViewHolder?>() {
    private var postsList: List<BookModel> = ArrayList()
    private val bookModel: BookModel? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(mContext)
            .inflate(R.layout.posts_ver_item_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindPost(postsList[position])
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    fun setList(moviesList: List<BookModel>) {
        postsList = moviesList
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var postTitle= itemView.title_tv
        var postImage= itemView.post_iv
        fun bindPost(bookModel: BookModel) {


            postTitle.text = bookModel.author


            Glide.with(mContext).load(R.drawable.cat).into(postImage)
        }


    }
}