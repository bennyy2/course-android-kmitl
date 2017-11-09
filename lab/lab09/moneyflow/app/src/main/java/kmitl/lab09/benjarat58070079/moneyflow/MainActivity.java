package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseTable databaseTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showtransection();


    }

    public void showtransection(){
        databaseTable = Room.databaseBuilder(getApplicationContext(),
                DatabaseTable.class, "DatabasseInfo")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

//        List<DatabaseInfo> result = databaseTable.getTableDAO().getAll();
//        ArrayAdapter<DatabaseInfo> adaptor = new ArrayAdapter<>(MainActivity.this,
//                R.layout.activity_list, result);
//
//        ListView messageInfoList = findViewById(R.id.messageList);
//        messageInfoList.setAdapter(adaptor);

        List<DatabaseInfo> result = databaseTable.getTableDAO().getAll();
        ArrayAdapter<DatabaseInfo> adaptor = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, result);

        ListView messageInfoList = findViewById(R.id.messageList);
        messageInfoList.setAdapter(adaptor);

    }



    public void addInfo(View view) {
        Intent intent = new Intent(MainActivity.this, AddTransection.class);
        startActivity(intent);
        showtransection();


    }

    @Override
    protected void onResume() {
        super.onResume();
        showtransection();
    }
}
