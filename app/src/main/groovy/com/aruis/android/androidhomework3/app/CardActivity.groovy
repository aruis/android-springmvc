package com.aruis.android.androidhomework3.app

import android.app.Activity
import android.os.Bundle
import com.aruis.android.androidhomework3.app.util.Consts
import com.aruis.android.androidhomework3.app.util.ImageDownloader

/**
 * Created by liurui on 15/4/24.
 */
class CardActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        def data = getIntent()?.getExtras()?.get('hello')
        findViewById(R.id.text1).text = data.name
        findViewById(R.id.text2).text = data.detail
        new ImageDownloader(findViewById(R.id.imageView)).execute([Consts.url + data.imgUrl] as String[])
    }
}
