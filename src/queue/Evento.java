package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 Crear una clase Asistente.
 Volver la cola no de enteros sino de asistentes
 Termina la implementación del método "procesarSiguienteCompra", reduciendo la cantidad de tickets
 disponibles dependiendo de los tickets comprados por el asistente.
 Cuando se venden todos los tickets se muestra un mensaje "Sold out"
 Todo a través de una interfaz de consola.
 */

public class Evento {
    Queue<Asistente> cola;
    int aforo;
    int cantDisponibles;

    public Evento(int aforo) {
        this.aforo = aforo;
        this.cantDisponibles = aforo;
        this.cola = new LinkedList();
    }

    public void registrarComprador(Asistente asistente){
        this.cola.add(asistente);

    }

    public void procesarSiguienteCompra() {
        // FIFO -> First In First Out
        Asistente sgte = this.cola.remove();
        //El primer asistente en llegar el primero en comprar
        if (sgte.getNumTiquetes()<=this.cantDisponibles){
            this.cantDisponibles-=sgte.getNumTiquetes();
            sgte.ingresoAceptado();
            System.out.println("Compra realizada por el usuario "+sgte.getNombreAsistente());
        }
        else{
            System.out.println("SOLD OUT");

        }
        // Agregar validación contra el aforo
        // Reducir la cantidad de boletas disponibles
    }
}

