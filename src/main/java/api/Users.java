package api;

import models.user.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface Users {
    @GET("users")
    Call<List<User>> findAll();

    @GET("users/{user}")
    Call<User> findById(@Path("user") Long userId);

    /* Dynamically updated header - auth example */
    @POST("users")
    Call<User> getByToken(@Header("Authorization") String auth);

    @POST("users")
    Call<User> save(@Body User user);

    @PUT("users/{user}")
    Call<User> update(@Path("user") Long userId, @Body User user);

    @DELETE("users/{user}")
    Call<User> delete(@Path("user") Long userId);

}
