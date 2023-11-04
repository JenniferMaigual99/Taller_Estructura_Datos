package queue;
import java.time.LocalDate;

public class Asistente {

    private String nombreAsistente;
    private int numTiquetes;
    private boolean ingreso;

    public Asistente(String nombreAsistente, int numTiquetes) {
        this.nombreAsistente = nombreAsistente;
        this.numTiquetes = numTiquetes;

        this.ingreso= false;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    public int getNumTiquetes() {
        return numTiquetes;
    }

    public void setNumTiquetes(int numTiquetes) {
        this.numTiquetes = numTiquetes;
    }



    public void ingresoAceptado(){
        this.ingreso=true;

    }

    public boolean isIngreso() {
        return ingreso;
    }
}