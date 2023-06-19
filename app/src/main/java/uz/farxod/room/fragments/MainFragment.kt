package uz.farxod.room.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import uz.farxod.room.R
import uz.farxod.room.User
import uz.farxod.room.UserDatabase
import uz.farxod.room.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentMainBinding.inflate(inflater, container, false)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = UserDatabase.getDatabaseInstance(requireContext())

        binding.buttonSave.setOnClickListener {
            if (binding.editLastname.text.isNotEmpty() && binding.editPhone.text.isNotEmpty() && binding.editEmail.text.isNotEmpty()) {
                database.userDao().addUser( // edit dan ma'lum ni bd-ga saqlaymiz
                    User(
                        0,
                        binding.editLastname.text.toString(),
                        binding.editPhone.text.toString(),
                        binding.editEmail.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "User is saved", Toast.LENGTH_SHORT).show()

                binding.editLastname.text.clear()
                binding.editPhone.text.clear()
                binding.editEmail.text.clear()
            }
            else Toast.makeText(requireContext(), "Pleas fill in the fields!", Toast.LENGTH_LONG).show()
        }

        binding.buttonShow.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, UserListFragment()).
            addToBackStack(MainFragment().toString()).commit()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}