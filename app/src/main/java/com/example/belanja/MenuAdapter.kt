import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belanja.R
import com.example.belanja.databinding.ItemMenuBinding

class MenuAdapter(val onMenuClick: OnMenuClick):
    RecyclerView.Adapter<MenuAdapter.MyHolder>() {

    private val menu = arrayOf(
        arrayOf(R.drawable.ic_goods,"Data Barang"),
        arrayOf(R.drawable.ic_shopping_cart,"Penjualan")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(menu[position][0] as Int, menu[position][1] as String)
        holder.binding.root.setOnClickListener{
            onMenuClick.onClick(menu[position][0] as Int)
        }
    }

    inner class MyHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(any: Int, any1: String) {
            binding.menuImage.setImageResource(any)
            binding.menuText.text = any1
        }
    }

    interface OnMenuClick {
        fun onClick(image: Int)
    }
}