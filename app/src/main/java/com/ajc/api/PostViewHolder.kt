package com.ajc.api


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(data: ResponseDTOItem) {
        view.tvId.text = data.id.toString()
        view.tvName.text = data.name
        view.tvEmail.text = data.email
        view.tvBody.text = data.body

//        Glide.with(view.ivOne)
//            .load(data.name)
//            // .error(R.drawable.imagenotfound)
//            .into(view.ivOne)
    }
}