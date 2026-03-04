package com.example.belajarintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Launcher untuk menerima balasan
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val dataBalasan = result.data?.getStringExtra("EXTRA_BALASAN")
            Toast.makeText(this, "Balasan: $dataBalasan", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPesan = findViewById<EditText>(R.id.etPesan)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        btnKirim.setOnClickListener {

            // 🔥 Buat object User
            val userBaru = User(
                nama = "Budi Doremi",
                email = "budi@email.com",
                umur = 25
            )

            val intent = Intent(this, SecondActivity::class.java)

            // Kirim object User
            intent.putExtra("EXTRA_USER", userBaru)

            // Tetap pakai launcher
            resultLauncher.launch(intent)
        }
    }
}