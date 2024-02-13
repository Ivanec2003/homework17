package com.example.homework17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework17.databinding.FragmentListCountryBinding


class ListCountryFragment : Fragment() {
    private lateinit var viewModel: ListCountryViewModel
    private lateinit var countryAdapter: MyAdapter

    private var _binding : FragmentListCountryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListCountryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, ListCountryViewModelFactory(ListCountryRepository(requireContext())))[ListCountryViewModel::class.java]
        viewModel.saveListCountry()
        clickBackToolbar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryAdapter = MyAdapter(emptyList()) // Ініціалізуємо адаптер з пустим списком країн
        binding.recyclerViewListWorker.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewListWorker.adapter = countryAdapter // Встановлюємо адаптер у RecyclerView

        // Спостерігання за змінами у списку країн
        viewModel.listCountry.observe(viewLifecycleOwner) { countries ->
            countryAdapter.updateData(countries) // Оновлюємо дані у адаптері
        }

        // Завантаження списку країн
        viewModel.fetchListCountry()
    }
    private fun clickBackToolbar(){
        binding.toolbarListCountry.setNavigationOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }
}