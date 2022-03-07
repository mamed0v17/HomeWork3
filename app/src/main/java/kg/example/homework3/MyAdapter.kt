package kg.example.homework3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.homework3.databinding.ItemListBinding
import kg.example.homework3.extensions.glide


class MyAdapter(private val list: MutableList<String>) : RecyclerView.Adapter<MyAdapter.ShitHolder>(){
    private lateinit var onClick: OnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShitHolder {
        return ShitHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.ShitHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setOnClick(onClick: OnClick) {
        this.onClick = onClick
    }

    inner class ShitHolder(private var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.apply {
                image.glide(s)
                itemView.setOnClickListener {
                    if (binding.proz.visibility == View.GONE) {
                        binding.proz.visibility = View.VISIBLE
                        onClick.onClicked(s)
                    } else {
                        binding.proz.visibility = View.GONE
                        onClick.onRemoved(s)
                    }
                }
            }
        }
    }

    interface OnClick {
        fun onClicked(position: String)
        fun onRemoved(position: String)
    }
}