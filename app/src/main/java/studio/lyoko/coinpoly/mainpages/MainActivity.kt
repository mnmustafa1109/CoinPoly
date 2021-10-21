package studio.lyoko.coinpoly.mainpages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import studio.lyoko.coinpoly.R
import studio.lyoko.coinpoly.dashboardpage.GameData
import studio.lyoko.coinpoly.dashboardpage.gamedata
import studio.lyoko.coinpoly.databinding.ActivityMainBinding


//TODO 1. search remain after reoving
//TODO 2. add completly random good quality random avatars

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
    }


}