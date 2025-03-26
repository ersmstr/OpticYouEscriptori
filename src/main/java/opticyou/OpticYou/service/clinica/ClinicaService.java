package opticyou.OpticYou.service.clinica;

/**
 * Autor: mrami
 */

import opticyou.OpticYou.dto.ClinicaDTO;
import opticyou.OpticYou.model.Clinica;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.*;
import opticyou.OpticYou.service.auth.*;

import java.util.List;

public class ClinicaService {
    private final ClinicaApi clinicaApi;

    public ClinicaService() {
        clinicaApi = ApiClient.getClient().create(ClinicaApi.class);  // Usamos ApiClient para obtener la instancia
    }
    // Método para obtener todas las clínicas
    public void cargarClinicas(String token) {
        clinicaApi.getAllClinicas(token).enqueue(new Callback<List<ClinicaDTO>>() {
            @Override
            public void onResponse(Call<List<ClinicaDTO>> call, Response<List<ClinicaDTO>> response) {
                if (response.isSuccessful()) {
                    List<ClinicaDTO> clinicas = response.body();
                    // Hacer algo con la lista de clínicas
                    System.out.println(clinicas);
                } else {
                    System.err.println("Error al obtener las clínicas.");
                }
            }

            @Override
            public void onFailure(Call<List<ClinicaDTO>> call, Throwable t) {
                // Manejar error
                System.err.println("Error: " + t.getMessage());
            }
        });
    }

    // Método para agregar una nueva clínica
    public void agregarClinica(ClinicaDTO clinicaDTO) {
        clinicaApi.createClinica(clinicaDTO).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    System.out.println("Clínica agregada correctamente");
                } else {
                    System.err.println("Error al agregar clínica.");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Manejar error
                System.err.println("Error: " + t.getMessage());
            }
        });
    }

    // Método para eliminar una clínica
    public void eliminarClinica(Long id, String token) {
        clinicaApi.deleteClinica(id, token).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    System.out.println("Clínica eliminada correctamente.");
                } else {
                    System.err.println("Error al eliminar la clínica.");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Manejar error
                System.err.println("Error: " + t.getMessage());
            }
        });
    }
    }

