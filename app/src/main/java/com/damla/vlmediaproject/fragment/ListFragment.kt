package com.damla.vlmediaproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.damla.vlmediaproject.R
import com.damla.vlmediaproject.adapter.CharacterRwAdapter
import com.damla.vlmediaproject.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val listViewModel by viewModel<ListFragmentViewModel>()
    private lateinit var binding: FragmentListBinding
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel.getCharacter()
        listViewModel.myResponse.observe(viewLifecycleOwner) { character ->
            recyclerView = binding.recyclerViewCharacter
            val characterAdapter = CharacterRwAdapter(character.results)
            binding.recyclerViewCharacter.apply {
                adapter = characterAdapter
                layoutManager = GridLayoutManager(requireContext(), 2)
            }


        }
        return binding.root

    }


}