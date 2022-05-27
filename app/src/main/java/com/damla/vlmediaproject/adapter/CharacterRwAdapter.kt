package com.damla.vlmediaproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.damla.vlmediaproject.R
import com.damla.vlmediaproject.api.model.Result
import com.damla.vlmediaproject.fragment.ListFragmentDirections
import com.damla.vlmediaproject.util.downloadFromURL
import com.damla.vlmediaproject.util.placeHolderProgressBar
import kotlinx.android.synthetic.main.character_row_rw.view.*

class CharacterRwAdapter(private val characterList: List<Result>) :
    RecyclerView.Adapter<CharacterRwAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_row_rw, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = characterList[position]
        val currentSrc = currentItem.image
        holder.itemView.tvCharacterAd.text = currentItem.name
        holder.itemView.imageCharacter.downloadFromURL(
            currentSrc,
            placeHolderProgressBar(holder.itemView.context)
        )
        holder.itemView.rootView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(currentItem.id)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}