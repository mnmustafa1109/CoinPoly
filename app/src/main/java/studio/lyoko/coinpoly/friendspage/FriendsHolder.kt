package studio.lyoko.coinpoly.friendspage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import studio.lyoko.coinpoly.R


class FriendsHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.freinds_list, parent, false)) {
    private var mNameView: TextView? = null
    private var mImageView: ImageView? = null
    private var mButtonView: Button? = null

    init {
        mNameView = itemView.findViewById(R.id.list_title)
        mImageView = itemView.findViewById(R.id.friends_icons)
        mButtonView= itemView.findViewById(R.id.remove_button)
    }

    fun returnTextView( ):TextView?{

        return mNameView
    }
    fun returnImageView( ):ImageView?{
        return mImageView
    }

    fun returnButtonView( ):Button?{
        return mButtonView
    }
}