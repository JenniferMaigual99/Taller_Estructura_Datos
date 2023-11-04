/**/
package queue;

public class Main {
    public static void main(String[] args) {
        Evento evento =new Evento(10);
        evento.registrarComprador(new Asistente("Luisa Guerrero",2));
        evento.registrarComprador(new Asistente("Luis Guerrero",6));
        evento.registrarComprador (new Asistente("Antonio Guerrero",1));
        evento.registrarComprador(new Asistente("Pablo Guerrero",5));
        while (evento.cola.peek()!= null){
            evento.procesarSiguienteCompra();
        }
    }
}
