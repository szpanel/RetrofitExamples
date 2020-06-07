package api;

import retrofit2.Retrofit;

import java.util.*;

public class RetrofitServices {
    private Retrofit retrofit;

    private Map<Class<?>, Object> services = new HashMap<>();

    public RetrofitServices(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public <T> void addService(Class<T> clazz) {
        if (!clazz.isInterface()) throw new IllegalArgumentException("Service must be an interface!");
        services.put(clazz, retrofit.create(clazz));
    }

    public <T> T getService(Class<T> clazz) {
        return clazz.cast(services.get(clazz));
    }
}
