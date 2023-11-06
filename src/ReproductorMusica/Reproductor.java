package ReproductorMusica;

import java.util.LinkedList;
import java.util.Queue;

public class Reproductor {
    private Cancion cancionActual;
    private Queue<Cancion> listaReproduccion;

    public Reproductor() {
        this.cancionActual = null;
        this.listaReproduccion = new LinkedList<>();
    }
    public void agregarCancion(Cancion cancion){
        this.listaReproduccion.add(cancion);
    }
    public void reproducirCancion(){
        if (this.listaReproduccion.peek()!= null) {
            this.cancionActual = this.listaReproduccion.remove();
            this.listaReproduccion.add(cancionActual);
            System.out.println("Estás escuchando: " + this.cancionActual);
        }else{
            System.out.println("No tiene canciones agregadas");
        }
    }

    public void eliminarCanción(String nombre){
        Cancion selectCancion = null;
        for (Cancion cancion : listaReproduccion) {
            if (cancion.getTitulo().equals(nombre)){
                selectCancion = cancion;
                break;
            }
        }
        if (selectCancion == null){
            System.out.println("No tienes esta canción en tu lista de reproducción");
        }
        else{
            listaReproduccion.remove(selectCancion);
        }
    }
}
