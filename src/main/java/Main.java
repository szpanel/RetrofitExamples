import api.RetrofitServices;
import api.Users;
import models.user.Address;
import models.user.Company;
import models.user.User;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    private RetrofitServices services;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        /* Creates retrofit instance with Gson Converter */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /* Creates custom kinda ServiceManager for retrofit interfaces */
        main.services = new RetrofitServices(retrofit);
        main.makeServices(main.services);

        Users service = main.services.getService(Users.class);

        /* Making API calls */
        List<User> users = service.findAll().execute().body();
        final User user = service.findById(4L).execute().body();
        User tempUser = service.findById(9L).execute().body();
        Response<User> savedUser = service.save(main.makeCustomUser()).execute();
        Response<User> updatedUser =
                service.update(tempUser.getId(), tempUser.setEmail("szpanelek@gmail.com")).execute();
        Response<User> deletedUser = service.delete(user.getId()).execute();



        /* Printing results */
        System.out.println("[GET]/users");
        Optional.ofNullable(users).ifPresent(u -> u.forEach(System.out::println));
        System.out.println("[GET]/users/{user}");
        System.out.println(user);
        System.out.println("[POST]/users");
        System.out.println("code: " + savedUser.code() + ", body: " + savedUser.body());
        System.out.println("[PUT]/users/{user}");
        System.out.println("code: " + updatedUser.code() + ", body: " + updatedUser.body());
        System.out.println("[DELETE]/users/{user}");
        System.out.println("code: " + deletedUser.code() + ", body: " + deletedUser.body());
    }

    private void makeServices(RetrofitServices services) {
        services.addService(Users.class);
    }

    private User makeCustomUser() {
        return new User()
                .setAddress(
                        new Address()
                                .setCity("Lodz")
                                .setGeo(
                                        new Address.Geo()
                                                .setLat(28.21)
                                                .setLng(-28.21)
                                )
                                .setStreet("Pomorska")
                                .setSuite("Apt. 22")
                                .setZipcode("00-000")
                )
                .setCompany(
                        new Company()
                                .setName("Mood company")
                                .setCatchPhrase("With passion")
                                .setBs("We are developing the world together.")
                )
                .setEmail("szpanelek@gmail.com")
                .setName("Lukas")
                .setPhone("123456789")
                .setUsername("szpanel")
                .setWebsite("https://github.com/szpanel")
                .setId(1337L);
    }
}
