package com.example.homework17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.homework17.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickButtonConfirm()
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
    private fun onClickButtonConfirm() {
        binding.buttonConfirm.setOnClickListener{
            val login = binding.textFieldEnterLogin.editText?.text.toString()
            val password = binding.textFieldEnterPassword.editText?.text.toString()
            if(viewModel.clickButtonConfirm(login, password)){
                val fragment = ListCountryFragment()
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack("")
                    .commit()
            }
        }
    }
}
