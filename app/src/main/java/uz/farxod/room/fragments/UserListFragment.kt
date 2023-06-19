package uz.farxod.room.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.farxod.room.R
import uz.farxod.room.UserDatabase
import uz.farxod.room.UserListAdapter
import uz.farxod.room.databinding.FragmentMainBinding
import uz.farxod.room.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val database = UserDatabase.getDatabaseInstance(requireContext())
        val list = database.userDao().getAllUsers().toMutableList()
        val adapter = UserListAdapter(list)

        binding.recyclerView.adapter = adapter

        val swipeCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                database.userDao().deleteUser(list[position]) // data dan uchirish uchun
                list.removeAt(position) // list dan uchirish uchun
                adapter.notifyItemRemoved(position) // adapter dan uchirish uchun

                Toast.makeText(requireContext(), "User deleted", Toast.LENGTH_SHORT).show()
            }

        }

        val itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)  //ushirish
    }
}