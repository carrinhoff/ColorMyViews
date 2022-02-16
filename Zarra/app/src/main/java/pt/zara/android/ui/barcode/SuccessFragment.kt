package pt.zara.android.ui.barcode

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_success.view.*
import pt.coolseg.android.utils.loadImage
import pt.zara.android.R
import pt.zara.android.databinding.FragmentSuccessBinding
import pt.zara.android.viewModel.ItemViewModel
import java.net.URI


class SuccessFragment : Fragment() {

    private lateinit var binding: FragmentSuccessBinding
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSuccessBinding.inflate(inflater, container, false)

            val safeArgs: SuccessFragmentArgs by navArgs()
            val code = safeArgs.code
            viewModel.getItem(code)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentSuccessButtonBackToScanner.setOnClickListener {
            findNavController().navigateUp()
        }
        observeViews()

    }

    private fun observeViews() {
        viewModel.item.observe(viewLifecycleOwner, {
            if (!it.primaryImageURL.isEmpty() && !it.description.isEmpty()){
                binding.mainImage.loadImage(it.primaryImageURL)
                binding.tvDescription.text = it.description
            }

        })
    }

}