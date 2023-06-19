package uz.farxod.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.farxod.room.databinding.ItemListBinding

class UserListAdapter(private val list: List<User>): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(user: User){
            binding.title.text = user.username
            binding.phone.text = user.phone
            binding.email.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}