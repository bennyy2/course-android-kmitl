package kmitl.lab11.benjarat58070079.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        display();


    }

    public void display(){
        TextView result = findViewById(R.id.txtView);
        result.setText(String.valueOf(counterViewModel.getCounter()));
    }



    public void onClickCount(View view) {
        counterViewModel.setCounter(counterViewModel.getCounter() + 1);
        display();
    }
}
