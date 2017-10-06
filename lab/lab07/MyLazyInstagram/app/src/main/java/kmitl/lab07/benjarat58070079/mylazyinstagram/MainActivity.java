package kmitl.lab07.benjarat58070079.mylazyinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kmitl.lab07.benjarat58070079.mylazyinstagram.Adapter.PostAdapter;
import kmitl.lab07.benjarat58070079.mylazyinstagram.api.LazyInstagramApi;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserProfile("cartoon");

        PostAdapter postAdapter = new PostAdapter(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);
    }



    //5.create method
    private void getUserProfile(String name){
        OkHttpClient client = new OkHttpClient
                .Builder()
                .build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(LazyInstagramApi.BASE)
                //using json(userprofile)
                .addConverterFactory(GsonConverterFactory.create())
                //using string (all object)
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        LazyInstagramApi lazyInstagramApi = retrofit.create(LazyInstagramApi.class);


        //6.call userprofile
        Call<Userprofile> call = lazyInstagramApi.getProfile(name);
        call.enqueue(new Callback<Userprofile>() {
            @Override
            public void onResponse(Call<Userprofile> call, Response<Userprofile> response) {
                //7.get object in userprofile to show in textview
                if (response.isSuccessful()){
                    Userprofile userprofile = response.body();
                    TextView textUser = (TextView) findViewById(R.id.textUser);
                    textUser.setText("@"+userprofile.getUser());
                    ImageView imageUser = (ImageView) findViewById(R.id.imageProfile);
                    Glide.with(MainActivity.this)
                            .load(userprofile.getUrlProfile())
                            .into(imageUser);
                }
            }

            @Override
            public void onFailure(Call<Userprofile> call, Throwable t) {
//                TextView textUser = (TextView) findViewById(R.id.textUser);
//                textUser.setText("56666");
            }
        });



    }
}
