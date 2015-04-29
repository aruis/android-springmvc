package com.aruis.android.androidhomework3.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.aruis.android.androidhomework3.app.util.Consts
import com.aruis.android.androidhomework3.app.util.Tool
import org.json.JSONArray

public class MainActivity extends Activity {

    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListData()
    }

    private void initListData() {
        ListView listView = findViewById(R.id.listView)

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                (adapterView.adapter as SimpleAdapter).data
                Map data = adapterView.getAdapter().getItem(i)

                Intent intent = new Intent()
                intent.setClass(MainActivity.this, CardActivity)
                intent.putExtra('hello', data)
                startActivityForResult(intent, 9527)

            }
        })

        Thread.start {

            String json = new URL(Consts.url + "task/list").text
            JSONArray jsonArray = new JSONArray(json)
            List dataList = Tool.toList(jsonArray)

            MyAdapter asdp = new MyAdapter(getApplicationContext(),
                    dataList, //数据源
                    R.layout.list_item, //行布局文件
                    ["name", "detail", "imgUrl"] as String[], //把MAP里面的key映射到ID中
                    [R.id.mainTW, R.id.subTW, R.id.itemImageView] as int[]);

            handler.post(new Runnable() {
                @Override
                void run() {
                    listView.setAdapter(asdp);
                }
            })
        }

    }

}
