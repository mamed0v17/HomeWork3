package kg.example.homework3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.example.homework3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MyAdapter.OnClick {

    private lateinit var binding: ActivityMainBinding
    private val image = mutableListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        goToShit()
    }

    private fun goToShit() {
        binding.btnOk.setOnClickListener {
            val intent = Intent(this, ShitActivity::class.java)
            intent.putExtra(SHIT, list)
            startActivity(intent)
        }
    }

    private fun initView() {
        adapter = MyAdapter(fullList())
        adapter.setOnClick(this)
        binding.recyclerView.adapter = adapter
    }

    private fun fullList(): MutableList<String> {
        for (i in 1..10) {
            image.add("https://upload.wikimedia.org/wikipedia/ru/e/e6/Goat_Simulator_logo.png")
        }
        return image
    }

    companion object {
        const val SHIT = "Shit"
    }

    override fun onClicked(position: String) {
        list.add(position)
    }

    override fun onRemoved(position: String) {
        list.remove(position)
    }
}