package ExpresionMatematica;

import java.util.Scanner;

import ReproductorMusica.Cancion;

public class Main {
    public static Scanner inSc = new Scanner(System.in);

    public static void main(String[] args) {
        String expression = "";
        Verificador verificador = new Verificador();
        while (expression != "-1") {
            System.out.print("Ingrese expresión a validar o para salir: '-1' > ");
            expression = inSc.nextLine();
            if (expression == "-1") {
                break;
            }
            verificador.setExpresion(expression);
            if (verificador.verificar()) {
                System.out.println("La expresión está correcta " + expression);
                System.out.println("El resultado es " + verificador.result());
            } else {
                System.out.println("La expresión es incorreta " + expression);
            }

        }
    }
}
