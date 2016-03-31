package com.aruis.android.androidhomework3.app

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.aruis.android.androidhomework3.app.util.Consts
import com.aruis.android.androidhomework3.app.util.ImageDownloader
import groovy.transform.CompileStatic

/**
 * Created by liurui on 15/4/24.
 */
@CompileStatic
class CardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = R.layout.activity_card
        Map data = getIntent()?.getExtras()?.get('hello') as Map
        (findViewById(R.id.text1) as TextView).text = data.name as String
        (findViewById(R.id.text2) as TextView).text = data.detail as String

        new ImageDownloader(findViewById(R.id.imageView) as ImageView).execute([Consts.url + data.imgUrl] as String[])
    }
}
