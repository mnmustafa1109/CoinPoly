package studio.lyoko.coinpoly.dashboardpage

import android.app.Application

class gamedata(val Name: String,
               val Money:Float,
               val Houses:Int,
               val Hotels:Int,
               val Dept:Float){
    fun getUser ():String{

        return Name
    }
    fun get_Money ():Float{

        return Money
    }
}

