package opticyou.OpticYou.controller;

/**
 * Autor: mrami
 */
import opticyou.OpticYou.model.Clinica;
import opticyou.OpticYou.service.clinica.ClinicaService;
import opticyou.OpticYou.dto.ClinicaDTO;
import opticyou.OpticYou.ui.crud.ClinicaCrudScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClinicaController {
    private ClinicaCrudScreen screen;
    private ClinicaService service;

    public ClinicaController(ClinicaCrudScreen screen) {
        this.screen = screen;
        this.service = new ClinicaService();

        // Listener per a l'acció d'afegir
        this.screen.setAfegirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clinica clinica = screen.crearClinicaDesdeFormulario();
                ClinicaDTO clinicaDTO = new ClinicaDTO(
                        clinica.getNom(),
                        clinica.getDireccio(),
                        clinica.getTelefon(),
                        clinica.getHorari_opertura(),
                        clinica.getHorari_tancament(),
                        clinica.getEmail()
                );
                service.agregarClinica(clinicaDTO);  // Passar a la capa de servei
            }
        });

        // Listener per a l'acció d'actualitzar
        this.screen.setActualitzarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí pots recuperar la clínica seleccionada i actualitzar-la
                // Per exemple, utilitzar l'ID de la taula per identificar l'element que vols actualitzar
            }
        });

        // Listener per a l'acció d'eliminar
        this.screen.setEliminarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí pots recuperar l'ID de la taula seleccionada i eliminar-la
            }
        });

        // Carregar les clíniques en la taula en iniciar la pantalla
        carregarClinicas();
    }

    public void carregarClinicas() {
        // Aquí podríem cridar el servei per carregar les clíniques i actualitzar la taula
        List<ClinicaDTO> clinicas = service.getAllClinicas();
        DefaultTableModel model = (DefaultTableModel) screen.getClinicaTable().getModel();
        model.setRowCount(0);  // Eliminar totes les files abans de tornar a afegir-les

        for (ClinicaDTO clinica : clinicas) {
            model.addRow(new Object[]{clinica.getNom(), clinica.getDireccio()});
        }
    }
}
