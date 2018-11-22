package com.example.muhammadmishlahulumam.kadesubmission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var item: MutableList<Model> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialized()

        list_club.layoutManager = LinearLayoutManager(this)
        list_club.adapter = Adapter(this, item) {
            toast("Anda Memilih ${it.nama}  ")
            startActivity(intentFor<DetailActivity>("isSuccess" to true).clearTask())
        }
    }
    private fun initialized() {
        val nama = resources.getStringArray(R.array.namaClub)
        val gambar = resources.obtainTypedArray(R.array.gambarClub)
        val deskripsi = resources.getStringArray(R.array.deskripsiClub)
        item.clear()
        for (i in nama.indices) {
            item.add(Model(nama[i], gambar.getResourceId(i, 0), deskripsi[i]))
        }
        gambar.recycle()
    }
}
