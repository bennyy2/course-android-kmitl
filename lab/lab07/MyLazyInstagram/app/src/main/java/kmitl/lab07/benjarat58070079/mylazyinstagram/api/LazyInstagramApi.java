package kmitl.lab07.benjarat58070079.mylazyinstagram.api;

import kmitl.lab07.benjarat58070079.mylazyinstagram.Userprofile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//0.create interface
public interface LazyInstagramApi {

    //1.link api
    String BASE = "https://us-central1-retrofit-course.cloudfunctions.net";

    //2.get from api
    @GET("/getProfile")
    //3.if call<String> u will get all else call each object
    Call<Userprofile> getProfile(@Query("user") String user);


}
