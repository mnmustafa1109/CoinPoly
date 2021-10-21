package studio.lyoko.coinpoly.mainpages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.os.Handler
import android.os.Looper
import studio.lyoko.coinpoly.R

class SplashActivity : AppCompatActivity() {
    private val splashiness:Long=2000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,
                MainActivity::class.java))

            // close this activity
            finish()
        }, splashiness)
    }
}