package opticyou.OpticYou.service.clinica;

import opticyou.OpticYou.dto.ClinicaDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Autor: mrami
 */
public interface ClinicaApi {
            // Crear una nueva clínica
        @POST("/clinica")
        Call<Void> createClinica(@Body ClinicaDTO clinicaDTO);

        // Obtener una clínica por ID
        @GET("/clinica/{id}/{token}")
        Call<ClinicaDTO> getClinicaById(@Path("id") Long id, @Path("token") String token);

        // Obtener todas las clínicas
        @GET("/clinica/{token}")
        Call<List<ClinicaDTO>> getAllClinicas(@Path("token") String token);

        // Actualizar una clínica
        @PUT("/clinica/update")
        Call<Void> updateClinica(@Body ClinicaDTO clinicaDTO);

        // Eliminar una clínica
        @DELETE("/clinica/{id}/{token}")
        Call<Void> deleteClinica(@Path("id") Long id, @Path("token") String token);
    }


