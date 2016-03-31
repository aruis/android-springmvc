package com.aruis.android.androidhomework3.app.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import groovy.transform.CompileStatic

/**
 * Created by liurui on 15/4/27.
 */
@CompileStatic
class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImagetesttest

    static HashMap imgMap = new HashMap<String, Bitmap>()

    public ImageDownloader(ImageView bmImagetesttest) {
        this.bmImagetesttest = bmImagetesttest;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];

        if (imgMap.containsKey(urldisplay))
            return imgMap[urldisplay]

        Bitmap mIcon11 = null;
        try {
            InputStream input = new URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(input);
            imgMap[urldisplay] = mIcon11
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImagetesttest.setImageBitmap(result);
    }
}
