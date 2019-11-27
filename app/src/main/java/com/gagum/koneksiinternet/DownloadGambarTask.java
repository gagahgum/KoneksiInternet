package com.gagum.koneksiinternet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadGambarTask extends AsyncTask<String, Void, Bitmap> {
    Context ctx;

    public DownloadGambarTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream in;
        try {
            URL myUrl = new URL(s1);
            HttpURLConnection myConn = (HttpURLConnection)myUrl.openConnection();
            myConn.connect();
            in = myConn.getInputStream();
            Bitmap myMap = BitmapFactory.decodeStream(in);
            return myMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        @Override protected void onPostExecute (Bitmap bitmap){
            MainActivity.gambar.setImageBitmap(bitmap);
        }
    }

