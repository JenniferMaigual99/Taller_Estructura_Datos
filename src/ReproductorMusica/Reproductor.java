package ReproductorMusica;


import java.util.Collection;
import java.util.Iterator;
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
        }else{
            System.out.println("No tiene canciones agregadas");
        }
    }

    public void eliminarCanción(String nombre){

    }
}
