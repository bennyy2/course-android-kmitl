package kmitl.lab07.benjarat58070079.mylazyinstagram;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kmitl.lab07.benjarat58070079.mylazyinstagram.Adapter.PostAdapter;
import kmitl.lab07.benjarat58070079.mylazyinstagram.api.LazyInstagramApi;
import kmitl.lab07.benjarat58070079.mylazyinstagram.model.Userprofile;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private int view = 1;
    private String users = "nature";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserProfile(users);

        Button grid_view = (Button) findViewById(R.id.grid_view);
        grid_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = 1;
                getUserProfile(users);
            }
        });

        Button list_view = (Button) findViewById(R.id.list_view);
        list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = 2;
                getUserProfile(users);
            }
        });

        Button user = (Button) findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(new CharSequence[]{"android", "nature", "cartoon"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                getUserProfile("android");
                                users = "android";
                                dialog.dismiss();
                                break;
                            case 1:
                                getUserProfile("nature");
                                users = "nature";
                                dialog.dismiss();
                                break;
                            case 2:
                                getUserProfile("cartoon");
                                users = "cartoon";
                                dialog.dismiss();
                                break;
                        }
                    }
                });
                builder.show();
            }
        });

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
                if (response.isSuccessful()) {
                    display(response.body());
                }
            }

            @Override
            public void onFailure(Call<Userprofile> call, Throwable t) {

            }
        });
                     }





    private void display(Userprofile userprofile){
        TextView textUser = (TextView) findViewById(R.id.textUser);
        textUser.setText("@"+userprofile.getUser());

        TextView textPost = (TextView) findViewById(R.id.textPost);
        textPost.setText("Post\n"+userprofile.getPost());

        TextView Following = (TextView) findViewById(R.id.Following);
        Following.setText("Following\n"+userprofile.getFollowing());

        TextView Follower = (TextView) findViewById(R.id.Follower);
        Follower.setText("Follower\n"+userprofile.getFollower());

        TextView textBio = (TextView) findViewById(R.id.textBio);
        textBio.setText(userprofile.getBio());

        ImageView imageUser = (ImageView) findViewById(R.id.imageProfile);
        Glide.with(MainActivity.this)
                .load(userprofile.getUrlProfile())
                .into(imageUser);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        if(view == 1){
            recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }

        PostAdapter postAdapter = new PostAdapter(this);
        postAdapter.setData(userprofile.getPosts());
        recyclerView.setAdapter(postAdapter);


    }


}
