package opticyou.OpticYou.model;

/**
 * Autor: mrami
 */
public class Clinica {
    private String nom;
    private String direccio;
    private String telefon;
    private String horari_opertura;
    private String horari_tancament;
    private String email;

    //constructor
    public Clinica(String nom, String direccio, String telefon, String horari_opertura, String horari_tancament, String email) {
        this.nom = nom;
        this.direccio = direccio;
        this.telefon = telefon;
        this.horari_opertura = horari_opertura;
        this.horari_tancament = horari_tancament;
        this.email = email;
    }
    //getters setters

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

    public String getHorari_opertura() {
        return horari_opertura;
    }

    public void setHorari_opertura(String horari_opertura) {
        this.horari_opertura = horari_opertura;
    }

    public String getHorari_tancament() {
        return horari_tancament;
    }

    public void setHorari_tancament(String horari_tancament) {
        this.horari_tancament = horari_tancament;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
