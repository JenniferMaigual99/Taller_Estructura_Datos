package ReproductorMusica;

import java.util.Scanner;


public class Main {

    public static Scanner inSc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        int duracion = 0;
        String autor = "";
        String titulo = "";

        Reproductor musica = new Reproductor();
        musica.agregarCancion(new Cancion(120, "Manuel", "La vaca lola"));
        musica.agregarCancion(new Cancion(130, "Manuel2", "La vaca lola1"));
        musica.agregarCancion(new Cancion(140, "Manuel3", "La vaca lola2"));
        musica.agregarCancion(new Cancion(150, "Manuel4", "La vaca lola4"));

        while (option!=-1) {
            System.out.println("1. Agreda cancion");
            System.out.println("2. Reproduce cancion");
            System.out.println("1. Elimina cancion");
            System.out.print("Ingrese seleccion: ");
            option = inSc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Duración (min): ");
                    duracion = inSc.nextInt();
                    System.out.println("Autor : ");

                    inSc.nextLine();

                    autor = inSc.nextLine();
                    System.out.println("Título de la canción: ");
                    titulo = inSc.nextLine();
                    musica.agregarCancion(new Cancion(duracion, autor, titulo));
                    break;
                case 2:
                    musica.reproducirCancion();
                    break;
                case 3:
                    System.out.println("Título de la canción a eliminar: ");
                    titulo = inSc.next();
                    musica.eliminarCanción(titulo);
                    break;
                default:
                    option = -1;
                    break;
            }
        }
    }
}