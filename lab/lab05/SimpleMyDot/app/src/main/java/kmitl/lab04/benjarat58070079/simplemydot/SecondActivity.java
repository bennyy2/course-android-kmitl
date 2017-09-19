package kmitl.lab04.benjarat58070079.simplemydot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kmitl.lab04.benjarat58070079.simplemydot.Model.DotPacelable;
import kmitl.lab04.benjarat58070079.simplemydot.Model.DotSerializable;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView tvValue = (TextView) findViewById(R.id.tvValue);
        TextView tvDot = (TextView) findViewById(R.id.tvDot);

        int x = getIntent().getIntExtra("xvalue", 0);
        tvValue.setText(String.valueOf(x));

//        DotSerializable dotSerializable = (DotSerializable) getIntent().getSerializableExtra("dotSerializable");
//        tvDot.setText("centerX : " + dotSerializable.getCenterX() + "\n" +
//                "centerY : " + dotSerializable.getCenterY());
//        tvDot.setTextColor(dotSerializable.getColor());


        DotPacelable dotparcelable = getIntent().getParcelableExtra("dotParcelable");
        tvDot.setText("Radius2 : " + dotparcelable.getRadius() + "\n" +
        "centerX Parcel : " + dotparcelable.getCenterX());
    }
}
