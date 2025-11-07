package com.quangvinh.baitap1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "BaiTap4_ChanLe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ẩn ActionBar / Title bar (Code này của bạn, giữ nguyên)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        // Tạo (nhập) một mảng ArrayList kiểu số nguyên
        val numbers = arrayListOf(5, 12, 8, 1, 99, 24, 7, 30, 16, 43)

        // In ra mảng gốc để kiểm tra trong Logcat
        Log.d(TAG, "Mảng số ban đầu: $numbers")

        // Tạo hai ArrayList rỗng để chứa kết quả phân loại
        val evenNumbers = ArrayList<Int>() // Mảng chứa các số chẵn
        val oddNumbers = ArrayList<Int>()  // Mảng chứa các số lẻ

        // Dùng vòng lặp 'for' để duyệt qua từng số trong mảng 'numbers'
        for (number in numbers) {
            // Kiểm tra xem số có chia hết cho 2 không
            if (number % 2 == 0) {
                // Nếu đúng, đây là số chẵn. Thêm nó vào mảng evenNumbers.
                evenNumbers.add(number)
            } else {
                // Nếu sai, đây là số lẻ. Thêm nó vào mảng oddNumbers.
                oddNumbers.add(number)
            }
        }

        Log.d(TAG, "CÁC SỐ CHẴN TÌM THẤY: $evenNumbers")
        Log.d(TAG, "CÁC SỐ LẺ TÌM THẤY:   $oddNumbers")


        val etInput  = findViewById<EditText>(R.id.etInput)
        val btnProc  = findViewById<Button>(R.id.btnProcess)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        btnProc.setOnClickListener {
            val s = etInput.text.toString().trim()

            if (s.isEmpty()) {
                tvOutput.text = "Vui lòng nhập chuỗi!"
                Toast.makeText(this, "Chuỗi trống!", Toast.LENGTH_SHORT).show()
            } else {
                // Đảo ngược thứ tự từ và in hoa
                val reversedUpper = s.split(Regex("\\s+"))
                    .asReversed()
                    .joinToString(" ")
                    .uppercase()

                // Gán kết quả đảo ngược vào TextView
                tvOutput.text = "Kết quả: $reversedUpper"

                // Hiển thị Toast phụ
                Toast.makeText(this, reversedUpper, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
