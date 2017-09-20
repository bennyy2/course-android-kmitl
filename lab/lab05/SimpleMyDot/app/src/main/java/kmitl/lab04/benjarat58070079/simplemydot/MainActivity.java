package kmitl.lab04.benjarat58070079.simplemydot;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import kmitl.lab04.benjarat58070079.simplemydot.Fragment.ViewDotFragment;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Colors;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dot;
import kmitl.lab04.benjarat58070079.simplemydot.Model.DotPacelable;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dots;
import kmitl.lab04.benjarat58070079.simplemydot.Model.ScreenShot;
import kmitl.lab04.benjarat58070079.simplemydot.View.DotView;



public class MainActivity extends AppCompatActivity{

    Button btnOpenActivity;
    Button share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();

        if(savedInstanceState == null) {
            initialFragment();
        }


        //share screenshot lab04
        share = (Button) findViewById(R.id.btnshare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bm = ScreenShot.takeScreenShot(view.getRootView());
                Uri uri = ScreenShot.getUri(getApplicationContext(), bm);
                startActivity(Intent.createChooser(shareIntent(uri), "Share Image Via"));
            }
        });

        //open 2nd activity lab04 in class
        btnOpenActivity = (Button) findViewById(R.id.btnOpenActivity);
        final DotPacelable dotParcelable = new DotPacelable(150, 150,50);
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("xvalue", 30);
                intent.putExtra("dotParcelable", dotParcelable);
                startActivity(intent);
            }
        });

    }

    private void initialFragment() {
        //fragment lab05
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.actview, new ViewDotFragment().newInstance()).commit();

    }


    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private Intent shareIntent(Uri uri) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setType("image/*");
        return intent;
    }


}




