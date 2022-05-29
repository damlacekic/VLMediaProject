package com.damla.vlmediaproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.damla.vlmediaproject.R
import com.damla.vlmediaproject.databinding.FragmentDetailBinding
import com.damla.vlmediaproject.util.downloadFromURL
import com.damla.vlmediaproject.util.placeHolderProgressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel by viewModel<DetailFragmentViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val id = args.characterId
        detailViewModel.getSingleCharacter(id)
        detailViewModel.myResponseSingle.observe(viewLifecycleOwner) { result ->
            if (result.status.equals("Alive")) {
                binding.statusColor.setBackgroundResource(R.drawable.status_shape_green)
            }

            if (result.status.equals("unknown")) {
                binding.statusColor.setBackgroundResource(R.drawable.status_shape_yellow)
            }

            binding.tvStatusSpecies.text = "${result.status} - ${result.species}"
            binding.tvDetailName.text = result.name
            binding.tvLastLocation.text = result.location.name
            binding.ivDetail.downloadFromURL(result.image, placeHolderProgressBar(requireContext()))

        }

        return binding.root

    }

}