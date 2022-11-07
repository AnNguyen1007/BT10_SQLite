package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BaiHocHelper baiHocHelper;
    ListView list;
    ArrayList<BaiHoc> arrayList;
    BaiHocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa listview
        list = (ListView)findViewById(R.id.lv_NoiDung);




        arrayList = new ArrayList<>();
        adapter = new BaiHocAdapter(this, R.layout.dong_noi_dung, arrayList);
        list.setAdapter(adapter);

        //Tao database:
        baiHocHelper = new BaiHocHelper(this, "baihoctable.sqlite",null,1);

        //tao bang
        baiHocHelper.QueryData("CREATE TABLE IF NOT EXISTS NoiDungTable(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenBai VARCHAR(200))");

        //Them du lieu(Chỉ chạy 1 lần -> tránh lặp lại dữ liệu)
        baiHocHelper.QueryData("INSERT INTO NoiDungTable VALUES (null, 'ABC')");
        baiHocHelper.QueryData("INSERT INTO NoiDungTable VALUES (null, 'MABC 2')");
        baiHocHelper.QueryData("INSERT INTO NoiDungTable VALUES (null, 'Mác)");

        //Hien thi
        action();
    }





    private void action(){
        Cursor dataBaiHoc = baiHocHelper.GetData("SELECT * FROM NoiDungTable");
        arrayList.clear();
        while (dataBaiHoc.moveToNext()){
            String ten = dataBaiHoc.getString(1);
            //Hien thi thong bao
            //Toast.makeText(this,ten,Toast.LENGTH_SHORT).show();
            //Hien thi list
            int id = dataBaiHoc.getInt(0);
            arrayList.add(new BaiHoc(id, ten));
        }
        adapter.notifyDataSetChanged();
    }
}