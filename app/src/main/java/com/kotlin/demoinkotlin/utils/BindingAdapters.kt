package com.kotlin.demoinkotlin.utils

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.BindingAdapter
import android.graphics.Color
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kotlin.demoinkotlin.ui.feeds.FeedsListActivity
import com.kotlin.demoinkotlin.ui.photos.PhotosListActivity
import com.kotlin.demoinkotlin.ui.posts.PostsListActivity
import com.kotlin.demoinkotlin.utils.extension.getParentActivity

/**
 * Created by satyanarayana on 11/9/18.
 **/

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?:""})
    }
}

@BindingAdapter("android:profileImage")
fun setImage(view: ImageView,imageUrl: String) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()

    if(parentActivity != null) {
        val circularProgressDrawable = CircularProgressDrawable(parentActivity)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.backgroundColor = Color.TRANSPARENT
        circularProgressDrawable.start()
       //Glide.with(view.context).load(imageUrl).into(view)
        Glide.with(view.getContext())
                .load(imageUrl)
                .placeholder(circularProgressDrawable)
                .into(view);
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("onClickUser")
fun setOnclickUser(view: View, userId: Int){

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    view.setOnClickListener({

        val intent = Intent(parentActivity, PostsListActivity::class.java)
        intent.putExtra("USER_ID",userId)

        if (parentActivity != null) {
            parentActivity.startActivity(intent)
        }
    })
}

@BindingAdapter("onClickPost")
fun setOnclickPost(view: View,activityName : String){

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    view.setOnClickListener({

        val intent = Intent(parentActivity, PhotosListActivity::class.java)

        if (parentActivity != null) {
            parentActivity.startActivity(intent)
        }
    })
}

@BindingAdapter("onClickPhoto")
fun setOnclickPhoto(view: View, photoUrl: String){

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    view.setOnClickListener({

        val intent = Intent(parentActivity, FeedsListActivity::class.java)

        if (parentActivity != null) {
            parentActivity.startActivity(intent)
        }
       //Toast.makeText(parentActivity,photoUrl,Toast.LENGTH_SHORT).show()
    })
}

@BindingAdapter("onClickFeed")
fun setOnclickFeed(view: View, authorName: String){

    val parentActivity: AppCompatActivity? = view.getParentActivity()
    view.setOnClickListener({

       Toast.makeText(parentActivity,"Author is"+authorName,Toast.LENGTH_SHORT).show()
    })
}
