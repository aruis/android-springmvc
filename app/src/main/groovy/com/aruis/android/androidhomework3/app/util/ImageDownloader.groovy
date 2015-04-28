package com.aruis.android.androidhomework3.app.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView

/**
 * Created by liurui on 15/4/27.
 */
class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;

    public ImageDownloader(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Log.i('-----',urldisplay)
        Bitmap mIcon11 = null;
        try {
            InputStream input = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            Log.e("Error -----", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
