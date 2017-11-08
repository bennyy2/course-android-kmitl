package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                DatabaseTable.class, "DatabasseInfo").build();


        new AsyncTask<Object, Object, List<DatabaseInfo>>(){

            @Override
            protected List<DatabaseInfo> doInBackground(Object... voids) {
                List<DatabaseInfo> result = databaseTable.getTableDAO().getAll();
                return result;
            }

            @Override
            protected void onPostExecute(List<DatabaseInfo> databaseInfos) {
                for(DatabaseInfo d: databaseInfos){
                    d.getAmount();



                }
                ArrayAdapter<DatabaseInfo> adaptor = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, databaseInfos);
                ListView messageInfoList = (ListView)findViewById(R.id.messageList);


                messageInfoList.setAdapter(adaptor);
            }
        }.execute();

    }



    public void addInfo(View view) {
        Intent intent = new Intent(MainActivity.this, AddTransection.class);

        startActivity(intent);
        showtransection();


    }

    public void update(View view) {
        showtransection();
    }
}
