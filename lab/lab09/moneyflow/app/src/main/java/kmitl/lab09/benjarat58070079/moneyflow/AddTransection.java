package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTransection extends AppCompatActivity {

    private int check = 0;
    public String type = "xx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transection);
    }


    public void onIncome(View view) {

    }

    public void onOutcome(View view) {
    }

    public void onSubmit(View view) {
        final EditText desc = (EditText) findViewById(R.id.description);
        EditText money = (EditText) findViewById(R.id.amountMoney);

        final String trans = desc.getText().toString();
        final int amountMoney = Integer.parseInt(money.getText().toString());
        DatabaseTable databaseTable = Room.databaseBuilder(getApplicationContext(),DatabaseTable.class, "DatabasseInfo").build();

        new AsyncTask<Void, Void, DatabaseInfo>(){

            @Override
            protected DatabaseInfo doInBackground(Void... voids) {
                DatabaseInfo databaseInfo = new DatabaseInfo();
                databaseInfo.setType(type);
                databaseInfo.setName(trans);
                databaseInfo.setAmount(amountMoney);

                return null;
            }
        }.execute();
        finish();

    }
}
