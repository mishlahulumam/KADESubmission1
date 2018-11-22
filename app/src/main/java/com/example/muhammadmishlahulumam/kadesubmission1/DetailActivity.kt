package com.example.muhammadmishlahulumam.kadesubmission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    lateinit var Nama: TextView
    lateinit var Keterangan: TextView
    lateinit var Gambar: ImageView
    var nama = ""
    var keterangan = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            Gambar = imageView {
                setImageResource(R.drawable.arsenal)
            }.lparams(width = 200, height = 200){
                gravity = Gravity.CENTER
                topMargin = dip(20)
            }
            Nama =  textView("Chelsea") {
                textSize = 29f
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(20)
            }
            Keterangan = textView("Chelsea Merupakan Club Liga Inggris") {
                textSize = 20f
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(20)
            }
        }

        //get Intent
        val i = intent
        nama = i.getStringExtra("nama")
        keterangan = i.getStringExtra("deskripsi")

        //set
        Gambar.setImageResource(i.getIntExtra("gambar",R.drawable.city))
        Nama.text = nama
        Keterangan.text = keterangan

    }
}
