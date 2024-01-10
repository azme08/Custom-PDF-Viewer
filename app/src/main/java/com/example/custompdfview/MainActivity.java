package com.example.custompdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class MainActivity extends AppCompatActivity {

    PDFView pdf1;
    LottieAnimationView lt1;
    public static String pdfname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdf1=findViewById(R.id.pdfView);
        lt1=findViewById(R.id.animationView);

        pdf1.setVisibility(View.INVISIBLE);
        lt1.setVisibility(View.VISIBLE);
        pdf1.fromAsset(pdfname)

                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        pdf1.setVisibility(View.VISIBLE);
                        lt1.setVisibility(View.GONE);
                       // Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .load();
    }
}