package com.gagum.koneksiinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    DownloadWebpageTask downloadWebpageTask;
    DownloadGambarTask downloadGambarTask;
    NetworkInfo networkInfo;
    TextView textStatusKoneksi;
    ConnectivityManager connMgr;
    static TextView tvSourcepage;
    static ImageView gambar;
    Button btnKoneksi;
    Button btnGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//         networkInfo = connMgr.getActiveNetworkInfo();


        tvSourcepage = findViewById(R.id.tvSourcepage);
        btnKoneksi = findViewById(R.id.button);
        btnKoneksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadWebpageTask = new DownloadWebpageTask(MainActivity.this);
                downloadWebpageTask.execute("http://google.com");
            }
        });
        gambar = findViewById(R.id.Gambar);
        textStatusKoneksi = findViewById(R.id.textStatusKoneksi);

        btnGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    downloadGambarTask = new DownloadGambarTask(MainActivity.this);
                            downloadGambarTask.execute("");
                } else {
                    textStatusKoneksi.setText("No network connection available.");
                }
            }
        });

    }


}
