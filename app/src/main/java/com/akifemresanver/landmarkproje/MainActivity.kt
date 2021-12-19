package com.akifemresanver.landmarkproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.LinearLayoutManager
import com.akifemresanver.landmarkproje.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //binding oluşturuldu,görünüm tarafına ulaşırız,event,form araçlarına
    private lateinit var landMarkList: ArrayList<LandMark>//sonradan başlatır,Landmark sınıfının nesnelerini tutar.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //xml ve back end kodunu arasında bağlantı sağlar
        //inflate geriye değer döndürür
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root//görünüme aldık
        setContentView(view)


        landMarkList = ArrayList<LandMark>()
        val pisa = LandMark("Pisa", "Turkiye", R.drawable.pisa)
        val eyfel = LandMark("Eyfel", "Fransa", R.drawable.eyfel)
        val londonBridge = LandMark("Londra", "İngiltere", R.drawable.londonbridge)
        val collesium =
            LandMark("Kolesyum", "Manavgat", R.drawable.collesium)

        landMarkList.add(pisa)
        landMarkList.add(eyfel)
        landMarkList.add(londonBridge)
        landMarkList.add(collesium)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = LandMarkAdapter(landMarkList)
        binding.recyclerView.adapter = adapter


        /*adapter - layout,data
        metin gösterilicekse android in olusturdugu sadece 1 adet gösterilicekse 1 xml var gösterilicek.
        map yazıp adapteri landmarkın nesnelerine çevirebiliriz,veriyi baska veriye çevirmeye yarar.lanmark objelerini lanmarkın ismine çevir.
        context= this,activite içindeyiz
        resources=değer,metin göstericeksek özel olan eventler kullanılır
        list=gosterilmesi istenen nesneyi classı çağırırız.lamba

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            landMarkList.map { landMark -> landMark.name })
        //oluşan listede yer alıcak itemler gelir.
        binding.listView.adapter = adapter
        //click üzerine tıklanınca gidilicek olan aktitive hazırlanır.
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(applicationContext, DetailsActivity::class.java)
                //listemizi yolluyoruz,serileştirmemiz için sınıfımıza kalıtım veririz.
                intent.putExtra("landMark", landMarkList.get(i))
                startActivity(intent)
                //landMarkList.get(i)
            }*/
    }
}