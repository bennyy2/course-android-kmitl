package kmitl.lab09.benjarat58070079.demodatabase;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MessageDB messageDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageDB = Room.databaseBuilder(getApplicationContext(),
                MessageDB.class, "Message")
                .build();

        new AsyncTask<Void, Void, MessageInfo>(){

            @Override
            protected MessageInfo doInBackground(Void... voids) {
                MessageInfo messageInfo = new MessageInfo();
                messageInfo.setText("Hello");
                messageInfo.setTime(new Date().toString());

                messageDB.getmessageInfoDAO().insert(messageInfo);
                return null;
            }


        }.execute();

        Button showMessagesBotton = (Button) findViewById(R.id.showMessageBtn);
        showMessagesBotton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        new AsyncTask<Void, Void, List<MessageInfo>>(){

            @Override
            protected List<MessageInfo> doInBackground(Void... voids) {
                List<MessageInfo> result = messageDB.getmessageInfoDAO().getAll();
                return result;
            }

            @Override
            protected void onPostExecute(List<MessageInfo> messageInfos) {
                ArrayAdapter<MessageInfo> adapter = new ArrayAdapter<MessageInfo>(MainActivity.this,
                android.R.layout.simple_list_item_1, messageInfos);

                ListView messageInfoList = findViewById(R.id.messageList);
                messageInfoList.setAdapter(adapter);
            }
        }.execute();
    }
}
