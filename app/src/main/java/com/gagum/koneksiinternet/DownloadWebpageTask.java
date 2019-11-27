package com.gagum.koneksiinternet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class DownloadWebpageTask extends AsyncTask<String, Void, String> {

    Context ctx;

    public DownloadWebpageTask(Context ct) {
        ctx = ct;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream in;

        try {
            URL myUrl = new URL(s1);
            HttpURLConnection myConn = (HttpURLConnection)myUrl.openConnection();
            myConn.connect();
            in = myConn.getInputStream();
            BufferedReader myBuff = new BufferedReader(new InputStreamReader(in));
            StringBuilder st = new StringBuilder();
            String Line="";
            while ((Line = myBuff.readLine()) != null) {
                st.append(Line + " \n");    }
            myBuff.close();
            in.close();
            return st.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.tvSourcepage.setText(s);
    }
}
