package stack;

import java.util.LinkedList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        Scanner sc = new Scanner(System.in);

        te.write("Hola");
        te.write("Mundo");

        te.ImprimirTexto();
        te.write("Adios");
        te.ImprimirTexto();
        te.undo();
        te.ImprimirTexto();

        while (true) {
            System.out.print("Ingrese una palabra: ");
            String palabra = sc.nextLine();

            if (palabra.equals("-1")) {
                te.undo();
            } else if (palabra.equals("+print")) {
                te.ImprimirTexto();
            } else {
                te.write(palabra);
            }
        }

    }
}