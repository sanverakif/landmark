package com.akifemresanver.landmarkproje

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akifemresanver.landmarkproje.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding //binding oluşturuldu,görünüm tarafına ulaşırız,event,form araçlarına
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityDetailsBinding.inflate(layoutInflater)//xml ve back end kodunu arasında bağlantı sağlar
        val view = binding.root//görünüme aldık
        setContentView(view)
        val intent = intent
        //cast, gelen veriyi aldık landmark olarak kaydettik.
        val selectedLandMark = intent.getSerializableExtra("landMark") as LandMark
        binding.nameText.text = selectedLandMark.name
        binding.nameText2.text = selectedLandMark.country
        binding.imageView.setImageResource(selectedLandMark.image)
    }
}