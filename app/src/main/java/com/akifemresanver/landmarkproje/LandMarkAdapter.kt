package com.akifemresanver.landmarkproje

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akifemresanver.landmarkproje.databinding.RecyclerRowBinding

/*recyclerview.adapter sınıfından kalıtım alındı.
viewholder:görünüm tutucu yardımcı sınıf:xml bağlama,textview içinde gösterilicek veriyi kontrol eden sınıftır.
lanmarkholder isminde yardımcı sınıf olusturduk.
*/

class LandMarkAdapter(val landMarkList: ArrayList<LandMark>) :
    RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {
    //recycler.viewholder sınıfından kalıtım alınıcak
    //class LandMarkHolder(view: View) : RecyclerView.ViewHolder(view) {
    class LandMarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    //oluşan viewholdera ilk olustugunda yapılması gereken yer
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandMarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {
        holder.binding.recyclerRowTextView.text = landMarkList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("landMark", landMarkList.get(position))
            holder.itemView.context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return landMarkList.size
    }
}