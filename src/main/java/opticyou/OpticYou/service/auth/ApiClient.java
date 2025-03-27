package opticyou.OpticYou.service.auth;

/**
 * Autor: mrami
 */

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import opticyou.OpticYou.service.clinica.ClinicaApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://host.docker.internal:8083/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    // Método para obtener el cliente de autenticación (Login/Logout)
    public static ApiClient getClientApi() {
        return getClient().create(ApiClient.class);
    }

    // Método para obtener el cliente de clínicas
    public static ClinicaApi getClinicaApi(String token) {
        // Aquí passarem el token per afegir-lo manualment als encapçalaments si és necessari.
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    // Afegir el token a l'encapçalament Authorization
                    return chain.proceed(chain.request().newBuilder()
                            .header("Authorization", "Bearer " + token)
                            .build());
                })
                .build();

        Retrofit retrofitWithToken = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofitWithToken.create(ClinicaApi.class);
    }
}

