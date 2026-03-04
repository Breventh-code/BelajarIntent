package com.example.belajarintent

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvHasilPesan = findViewById<TextView>(R.id.tvHasilPesan)
        val etBalasan = findViewById<EditText>(R.id.etBalasan)
        val btnBalas = findViewById<Button>(R.id.btnBalas)

        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_USER", User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<User>("EXTRA_USER")
        }

        // Jika ada user → tampilkan
        if (user != null) {
            val info = """
                Nama: ${user.nama}
                Email: ${user.email}
                Umur: ${user.umur}
            """.trimIndent()

            tvHasilPesan.text = info
        } else {
            // Kalau tidak ada user, ambil pesan biasa
            val pesanDiterima = intent.getStringExtra("EXTRA_PESAN")
            tvHasilPesan.text = pesanDiterima
        }

        btnBalas.setOnClickListener {
            val balasan = etBalasan.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("EXTRA_BALASAN", balasan)

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}