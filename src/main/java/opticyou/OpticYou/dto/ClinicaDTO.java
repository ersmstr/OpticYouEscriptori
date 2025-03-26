package opticyou.OpticYou.dto;

/**
 * Autor: mrami
 */
public class ClinicaDTO {
    private String nom;
    private String direccio;
    private String telefon;
    private String horari_opertura;
    private String horari_tancament;
    private String email;

    // Getters y setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String gethorari_opertura() {
        return horari_opertura;
    }

    public void sethorari_opertura(String horari_opertura) {
        this.horari_opertura = horari_opertura;
    }

    public String getHorariTancament() {
        return horari_tancament;
    }

    public void setHorariTancament(String horariTancament) {
        this.horari_tancament = horariTancament;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
