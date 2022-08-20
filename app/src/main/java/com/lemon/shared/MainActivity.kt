package com.lemon.shared

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val et_hello: EditText by lazy{
        findViewById(R.id.et_hello)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 저장된 데이터를 로드하는 부분
        loadData()  // 저장되어있던 값을 setText
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref",0)
        et_hello.setText(pref.getString("name",""))  // key, key이 없을 경우 대체 값
    }
    private fun saveData() {
        val pref = getSharedPreferences("pref",0)  // 폴더경로에 pref를 저장 / 옵션
        val edit = pref.edit()  // 수정모드
        edit.putString("name",et_hello.text.toString()) //key, value
        edit.apply()
    }



    override fun onDestroy() {  // 해당 엑티비티가 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData()  // edit text 값을 저장

    }


}