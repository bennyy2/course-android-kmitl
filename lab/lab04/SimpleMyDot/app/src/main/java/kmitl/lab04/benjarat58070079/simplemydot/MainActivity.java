package kmitl.lab04.benjarat58070079.simplemydot;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import kmitl.lab04.benjarat58070079.simplemydot.Model.Colors;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dot;
import kmitl.lab04.benjarat58070079.simplemydot.Model.DotParcelable;
import kmitl.lab04.benjarat58070079.simplemydot.Model.DotSerializable;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dots;
import kmitl.lab04.benjarat58070079.simplemydot.Model.ScreenShot;
import kmitl.lab04.benjarat58070079.simplemydot.View.DotView;



public class MainActivity extends AppCompatActivity implements Dots.OnDotsChangeListener, DotView.OnDotViewPressListener {


    private DotView dotView;
    private Dots dots;
//    Button btnOpenActivity;
    Button share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermission();
        share = (Button) findViewById(R.id.btnshare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bm = ScreenShot.takeScreenShot(view.getRootView());
                Uri uri = ScreenShot.getUri(getApplicationContext(), bm);
                startActivity(Intent.createChooser(shareIntent(uri), "Share Image Via"));
            }
        });

        dotView = (DotView) findViewById(R.id.dotview);
        dotView.setOnDotViewPressListener(this);
        dots = new Dots();
        dots.setListener(this);

    }

    public void onShare(View view) {
        Bitmap image = ScreenShot.takeScreenShot(view.getRootView());
        Uri uri = ScreenShot.getUri(getApplicationContext(), image);
        startActivity(Intent.createChooser(shareIntent(uri), "Share Image Via"));
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


    public void onRandomDot(View view) {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 30, new Colors().getColor());
        dots.addDot(newDot);

    }

    public void onResetDot(View view) {
        dots.clearAll();
    }



    @Override
    public void onDotsChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();

    }

    @Override
    public void onDotViewPressed(int x, int y) {
        int dotPosition = dots.findDot(x, y);
        if (dotPosition == -1) {
            Dot newDot = new Dot(x, y, 30, new Colors().getColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }

    }




}




