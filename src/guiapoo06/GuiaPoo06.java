/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoo06;

import Nespreso.Cafetera;
import Servicios.Servicio;
import java.util.Scanner;

/**
 *
 * @author LizzW
 *
 * Programa Nespresso. Desarrolle una clase Cafetera con los atributos
 * capacidadMaxima (la cantidad máxima de café que puede contener la cafetera) y
 * cantidadActual (la cantidad actual de café que hay en la cafetera).
 * Implemente, al menos, los siguientes métodos:  Constructor predeterminado o
 * vacío  Constructor con la capacidad máxima y la cantidad actual
 *
 *  Métodos getters y setters.  Método llenarCafetera(): hace que la cantidad
 * actual sea igual a la capacidad máxima.  Método servirTaza(int): se pide el
 * tamaño de una taza vacía, el método recibe el tamaño de la taza y simula la
 * acción de servir la taza con la capacidad indicada. Si la cantidad actual de
 * café “no alcanza” para llenar la taza, se sirve lo que quede. El método le
 * informará al usuario si se llenó o no la taza, y de no haberse llenado en
 * cuanto quedó la taza.  Método vaciarCafetera(): pone la cantidad de café
 * actual en cero.  Método agregarCafe(int): se le pide al usuario una cantidad
 * de café, el método lo recibe y se añade a la cafetera la cantidad de café
 * indicada.
 */
public class GuiaPoo06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opc;
        String res;
        Servicio serv = new Servicio();
        Cafetera caf = new Cafetera();

        do {
            System.out.println("===========MENU============");
            System.out.println("1.- Llenar Cafetera");
            System.out.println("2.- Servir taza");
            System.out.println("3.- Agregar café");
            System.out.println("4.- Vaciar cafetera");
            System.out.println("5.- Salir");
            System.out.println("Elija opción:");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    serv.llenarCafetera(caf);
                    break;
                case 2:
                    serv.servirTaza(caf.getCantidadActual(), caf);
                    break;
                case 3:
                    serv.agregarCafe(caf.getCantidadActual(), caf);
                    break;
                case 4:
                    serv.vaciarCafetera(caf);
                    break;
                case 5:
                    System.out.println("¿En realidad desea salir? S/N");
                    res = sc.next();
                    if ("S".equalsIgnoreCase(res)) {
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    } else {
                        opc = 0;
                    }
                default:
                    throw new AssertionError();
            }
        } while (!salir);

    }

}
