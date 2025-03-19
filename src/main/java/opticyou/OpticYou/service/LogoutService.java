package opticyou.OpticYou.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;

public class LogoutService {
    // Método para hacer logout
    public void logout(String token) {
        AuthServiceClient authServiceClient = new AuthServiceClient();
        authServiceClient.logout(token, new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body();
                    if (success) {
                        System.out.println("Logout exitoso.");
                        // Aquí puedes hacer algo después de que el logout haya sido exitoso
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo hacer logout.", "Error de Logout", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la respuesta del servidor.", "Error de Logout", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                JOptionPane.showMessageDialog(null, "Error de red al hacer logout.", "Error de Logout", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
