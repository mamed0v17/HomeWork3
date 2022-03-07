package kg.example.homework3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.example.homework3.databinding.ActivityShitBinding

class ShitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getStringArrayListExtra(MainActivity.SHIT)
        binding.apply {
            recyclerViewTwo.adapter = list?.let { MyAdapter(it) }
            ivExit.setOnClickListener {
                finish()
            }
        }


    }
}