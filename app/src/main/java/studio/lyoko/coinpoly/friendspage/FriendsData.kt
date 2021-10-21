package studio.lyoko.coinpoly.friendspage

import android.view.View

public class FriendsData (val Name: String, val image: Int){
    fun getUser ():String{

        return Name
    }
    fun getCol ():Int{

        return image
    }
}