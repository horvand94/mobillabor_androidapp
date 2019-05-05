package com.example.mobillaborandroidapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.card_movie.view.*

class MainAdapter constructor(
    private val context: Context,
    private var movies: List<Movie>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.tvTitle.text = movie.title
        holder.tvRating.text = movie.rating.toString()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvTitle: TextView = view.tvTitle
        var tvRating: TextView = view.tvRating

        init {
            view.setOnClickListener { v: View  ->
                var position: Int = adapterPosition

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()

                var context = view.context
                val intent = Intent(context, MovieActivity::class.java)
                intent.putExtra("MovieItemPosition", position.toString())
                intent.putExtra("MovieItemTitle", view.tvTitle.text)
                context.startActivity(intent)

            }
        }

    }

}