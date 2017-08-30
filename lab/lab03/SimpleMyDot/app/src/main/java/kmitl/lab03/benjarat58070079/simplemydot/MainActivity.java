package kmitl.lab03.benjarat58070079.simplemydot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kmitl.lab03.benjarat58070079.simplemydot.model.Dot;
import kmitl.lab03.benjarat58070079.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity implements Dot.OnDotChangedListener {


    private DotView dotview;
    private Dot dot;
    private ArrayList<Dot> dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dots = new ArrayList<>();
        dotview = (DotView) findViewById(R.id.dotview);

    }


    public void onRandomDot(View view) {
        Random random = new Random();
        int centerX = random.nextInt(700);
        int centerY = random.nextInt(1000);
        int color = Color.argb(255, random.nextInt(256),random.nextInt(256),random.nextInt(256));
        Dot dot = new Dot(this, centerX, centerY, random.nextInt(60), color);
        dots.add(dot);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Random random = new Random();
            int color = Color.argb(255, random.nextInt(256),random.nextInt(256),random.nextInt(256));
            Dot dot = new Dot(this,event.getX(),event.getY()-150,random.nextInt(60),color);
            dots.add(dot);
            dotview.invalidate();
        }

        return false;

    }

    public void onResetDot(View view){
        dots.clear();
        dotview.invalidate();
    }

    @Override
    public void onDotChanged(Dot dot) {

        dotview.setDot(dots);
        dotview.invalidate();

    }
}
