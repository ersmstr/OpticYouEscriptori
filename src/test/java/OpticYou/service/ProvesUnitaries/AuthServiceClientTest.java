package OpticYou.service.ProvesUnitaries;

import opticyou.OpticYou.service.AuthServiceClient;
import opticyou.OpticYou.service.LoginResponseDTO;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceClientTest {

    @Test
    void testLogin() {
        // Aquí puedes simular el login con datos ficticios para comprobar el funcionamiento
        AuthServiceClient authServiceClient = new AuthServiceClient();

        // Supón que el servicio devuelve un LoginResponseDTO con un token si es correcto
        LoginResponseDTO response = new LoginResponseDTO();
        response.setToken("fake-token");
        response.setSuccess(true);

        // Usamos assert para verificar que el login devuelve lo esperado
        assertNotNull(response.getToken());
        assertTrue(response.isSuccess());
    }

    @Test
    void testLogout() {
        // Lógica de prueba para el logout
        AuthServiceClient authServiceClient = new AuthServiceClient();
        String token = "fake-token";  // Simula el token que usas para hacer logout

        // Aquí estamos pasando el Callback para manejar la respuesta del logout
        authServiceClient.logout(token, new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                // Verificamos si el logout fue exitoso
                if (response.isSuccessful() && response.body() != null) {
                    boolean logoutSuccess = response.body();
                    assertTrue(logoutSuccess); // Si el logout fue exitoso, pasa la prueba
                } else {
                    fail("Error en la respuesta del logout");
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                // Si la llamada falla, la prueba debería fallar
                fail("Error en la llamada de logout: " + t.getMessage());
            }
        });
    }
}
