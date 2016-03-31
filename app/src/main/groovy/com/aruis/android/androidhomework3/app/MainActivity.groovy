package com.aruis.android.androidhomework3.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.aruis.android.androidhomework3.app.util.Consts
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import groovy.transform.CompileStatic

@CompileStatic
public class MainActivity extends Activity {

    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = R.layout.activity_main
        initListData()
    }

    private void initListData() {
        ListView listView = findViewById(R.id.listView) as ListView

        listView.onItemClickListener = { AdapterView<?> adapterView, View view, int i, long l ->
            HashMap data = (adapterView.getAdapter() as MyAdapter).getItem(i) as HashMap

            Intent intent = new Intent()
            intent.setClass(getApplicationContext(), CardActivity.class)
            intent.putExtra('hello', data)
            startActivityForResult(intent, 9527)
        }

        Thread.start {

            String json = new URL(Consts.url + "task/list").text
            List dataList = new JsonSlurper().parseText(json) as List

            dataList = dataList.collect {
                new HashMap(it as LazyMap)
            }

            MyAdapter asdp = new MyAdapter(getApplicationContext(),
                    dataList as List<? extends Map<String, ?>>, //数据源
                    R.layout.list_item, //行布局文件
                    ["name", "detail", "imgUrl"] as String[], //把MAP里面的key映射到ID中
                    [R.id.mainTW, R.id.subTW, R.id.itemImageView] as int[]);

            handler.post {
                listView.setAdapter(asdp);
            }
        }

    }

}
