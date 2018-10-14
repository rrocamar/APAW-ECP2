package entities;

public class Moto {

    private String id;

    private String matricula;

    private boolean ITVpasada;

    public Moto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isITVpasada() {
        return ITVpasada;
    }

    public void setITVpasada(boolean ITVpasada) {
        this.ITVpasada = ITVpasada;
    }
}
