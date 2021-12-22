package ipca.example.mapboxapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ipca.example.mapboxapp.databinding.ActivityLocationBinding
import ipca.example.mapboxapp.databinding.ActivityNavegateBinding

class NavegateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNavegateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        binding = ActivityNavegateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                this.window.statusBarColor = getColor(R.color.black)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                this.window.statusBarColor = getColor(R.color.white)}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                this.window.statusBarColor = getColor(R.color.white)}
        }
        binding.button.setOnClickListener {
            startActivity(Intent(this, NavegatingActivity::class.java))
        }
    }
}