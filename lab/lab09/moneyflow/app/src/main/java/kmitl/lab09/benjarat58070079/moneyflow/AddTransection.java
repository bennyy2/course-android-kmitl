package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTransection extends AppCompatActivity {

    private int check = 0;
    public String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transection);
    }


    public void onIncome(View view) {
        type = "+";

    }

    public void onExpense(View view) {
        type = "-";
    }

    public void onSubmit(View view) {
        final EditText desc = findViewById(R.id.description);
        EditText money = findViewById(R.id.amountMoney);

        final String trans = desc.getText().toString();
        final int amountMoney = Integer.parseInt(money.getText().toString());
        DatabaseTable databaseTable = Room.databaseBuilder(getApplicationContext(),DatabaseTable.class, "DatabasseInfo")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        DatabaseInfo databaseInfo = new DatabaseInfo();
        databaseInfo.setType(type);
        databaseInfo.setName(trans);
        databaseInfo.setAmount(amountMoney);

        databaseTable.getTableDAO().insert(databaseInfo);

        finish();

    }
}
