package kmitl.lab04.benjarat58070079.simplemydot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kmitl.lab04.benjarat58070079.simplemydot.Model.DotParcelable;
import kmitl.lab04.benjarat58070079.simplemydot.Model.DotSerializable;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //intent
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //back to mainact
                finish();


            }
        }
        );

        TextView tvValue = (TextView) findViewById(R.id.tvValue);
        TextView tvDot = (TextView) findViewById(R.id.tvDot);

        //get value from main
        int x = getIntent().getIntExtra("xvalue", 0);

        DotSerializable dotSerializable = (DotSerializable) getIntent().getSerializableExtra("dotSerializable");

        //set value to show in textview
        tvValue.setText(String.valueOf(x));

        tvDot.setText("centerX : " + dotSerializable.getCenterX() + "\n" +
        "centerY : " + dotSerializable.getCenterY() +  "\n" +
        "Radius : " + dotSerializable.getRadius());
        tvDot.setTextColor(dotSerializable.getColor());

        DotParcelable dotparcelable = getIntent().getParcelableExtra("dotParcelable");
        tvDot.setText("Radius2 : " + dotparcelable.getRadius());

    }
}
