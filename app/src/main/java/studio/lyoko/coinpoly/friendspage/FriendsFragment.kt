package studio.lyoko.coinpoly.friendspage

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.editdrawabletext.DrawablePosition
import com.mindorks.editdrawabletext.OnDrawableClickListener
import kotlinx.android.synthetic.main.fragment_friends.*
import studio.lyoko.coinpoly.R
import studio.lyoko.coinpoly.dashboardpage.GameData
import studio.lyoko.coinpoly.dashboardpage.gamedata
import studio.lyoko.coinpoly.databinding.FragmentFriendsBinding


class FriendsFragment : Fragment() {

    private var random  = listOf(1,2,3,4,5).shuffled()
    private val FriendsList = mutableListOf<FriendsData>()
    private lateinit var binding: FragmentFriendsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }



    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun generateAvatar() : Int{
        var  generated : Int
        generated = 0
        when {
            random[FriendsList.size]==1 -> {
                generated= R.drawable.avatar_1
            }
            random[FriendsList.size]==2 -> {
                generated= R.drawable.avatar_2
            }
            random[FriendsList.size]==3 -> {
                generated= R.drawable.avatar_3
            }
            random[FriendsList.size]==4 -> {
                generated= R.drawable.avatar_4
            }
            random[FriendsList.size]==5 -> {
                generated= R.drawable.avatar_5
            }

        }


        return generated
    }




    fun fixvisibility(){
        if (FriendsList.size!=0){binding.nextButtonFriends.visibility = View.VISIBLE}
        else {binding.nextButtonFriends.visibility = View.INVISIBLE}
        if (FriendsList.size==5){binding.editTextTextPersonName.visibility = View.INVISIBLE}
        else {binding.editTextTextPersonName.visibility = View.VISIBLE}
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                                                  savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(
        inflater,
        R.layout.fragment_friends, container, false)
        binding.editTextTextPersonName.setDrawableClickListener(object : OnDrawableClickListener {
            override fun onClick(target: DrawablePosition) {
                when (target) {
                    DrawablePosition.RIGHT ->
                    {
                        random.shuffled()
                        hideKeyboard()
                        FriendsList += FriendsData(
                            binding.editTextTextPersonName.text.toString(),
                            generateAvatar()
                        )
                        fixvisibility()

                    }
                    else -> {
                        System.exit(0)
                    }


                }
            }
        })
        binding.nextButtonFriends.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_dashboardFragment))

        return binding.root

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        friends_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter =
                FriendsAdapter(FriendsList as ArrayList<FriendsData>)
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        for (i in 0..FriendsList.size-1) {
            GameData.DataLists.add(gamedata(FriendsList[i].getUser(),1500.toFloat(),0,0,0.toFloat()))
        }
    }




}