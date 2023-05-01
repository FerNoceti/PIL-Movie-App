package com.pil.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pil.movieapp.R
import com.pil.movieapp.databinding.ItemRecyclerBinding
import com.pil.movieapp.service.model.Movie

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRecyclerBinding.bind(itemView)

        fun bind(movie: Movie) {
            binding.id.text = itemView.context.getString(R.string.card_id, movie.id.toString())
            binding.title.text = itemView.context.getString(R.string.card_title, movie.title)
            binding.overview.text = itemView.context.getString(R.string.card_overview, movie.overview)
            binding.date.text = itemView.context.getString(R.string.card_release_date, movie.releaseDate)
            binding.voteAverage.text = itemView.context.getString(R.string.card_vote_average, movie.voteAverage.toString())
            binding.voteAverage.setTextColor(calculateColor(movie.voteAverage))

            Glide.with(itemView.context)
                .load(itemView.context.getString(R.string.card_poster_path, movie.posterPath))
                .into(binding.image)
        }

        private fun calculateColor(voteCount: Float): Int {
            return when {
                voteCount < 4 -> itemView.context.getColor(R.color.red)
                voteCount < 6 -> itemView.context.getColor(R.color.orange)
                voteCount < 7 -> itemView.context.getColor(R.color.yellow)
                else -> itemView.context.getColor(R.color.green)
            }
        }
    }
}
