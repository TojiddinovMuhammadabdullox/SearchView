package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.searchview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = arrayOf("Zaxiriddin","Mahmudaxon","Muhammadabdulloh","Dilafruz","Muhammadziyo")
        val userAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            user
        )

        binding.listView.adapter=userAdapter;

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                binding.searchView.clearFocus()
                if (user.contains(p0)){
                    userAdapter.filter.filter(p0)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                userAdapter.filter.filter(p0)
                return false
            }

        })
    }
}