package com.example.mobillaborandroidapp.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.card_movie.*
import kotlinx.android.synthetic.main.card_movie.view.*
import java.net.URL
import android.widget.*


class MainAdapter constructor(
    private val context: Context,
    private var movies: ArrayList<Movie>,
    private val mainPresenter: MainPresenter) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(com.example.mobillaborandroidapp.R.layout.card_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.tvTitle.text = movie.title

        holder.btnDelete.setImageResource(com.example.mobillaborandroidapp.R.drawable.baseline_delete_24)

        holder.btnDelete.setOnClickListener { v: View  ->
            mainPresenter.deleteMovie(position)
        }

        holder.ratingBar.rating = movie.rating!!


        val url = "http://image.tmdb.org/t/p/w92" + movie.posterUrl
        Glide.with(context).load(url).into(holder.ivImage)


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvTitle: TextView = view.tvTitle
        var btnDelete: ImageButton = view.btnDelete
        var ratingBar: RatingBar = view.ratingBarMovies

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