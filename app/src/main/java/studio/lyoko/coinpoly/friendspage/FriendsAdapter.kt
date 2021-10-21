package studio.lyoko.coinpoly.friendspage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FriendsAdapter(private val list: ArrayList<FriendsData>) : RecyclerView.Adapter<FriendsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FriendsHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FriendsHolder, position: Int) {
        val gameData: FriendsData = list[position]
        holder.returnTextView()?.text = gameData.Name
        holder.returnImageView()?.setImageResource(gameData.image)
        holder.returnButtonView()?.setOnClickListener {
            removeitem(position)

        }
    }

    override fun getItemCount(): Int = list.size

    fun removeitem(position: Int) {

        list.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()

    }

}
