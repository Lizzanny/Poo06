/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Nespreso.Cafetera;
import static java.lang.Math.abs;
import java.util.Scanner;

/**
 *
 * @author LizzW
 * Programa Nespresso. Desarrolle una clase Cafetera con los atributos
 * capacidadMaxima (la cantidad máxima de café que puede contener la cafetera) y
 * cantidadActual (la cantidad actual de café que hay en la cafetera).
 * Implemente, al menos, los siguientes métodos:  Constructor predeterminado o
 * vacío  Constructor con la capacidad máxima y la cantidad actual
 *
 *  Métodos getters y setters. 
 *  Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad máxima. 
 *  Método servirTaza(int): se pide el tamaño de una taza vacía, el método recibe el tamaño 
 * de la taza y simula la acción de servir la taza con la capacidad indicada. Si la cantidad actual de
 * café “no alcanza” para llenar la taza, se sirve lo que quede. El método le
 * informará al usuario si se llenó o no la taza, y de no haberse llenado en
 * cuanto quedó la taza. 
 *  Método vaciarCafetera(): pone la cantidad de café
 * actual en cero. 
 *  Método agregarCafe(int): se le pide al usuario una cantidad
 * de café, el método lo recibe y se añade a la cafetera la cantidad de café
 * indicada.
 */
public class Servicio {
    private Scanner sc = new Scanner(System.in);
    //Cafetera caf = new Cafetera();
    
    public Cafetera llenarCafetera(Cafetera caf){
        int cantidad;
         System.out.println("Indicar cantidad para llenar cafetera:");
         cantidad = sc.nextInt();
         if(cantidad<=(caf.getCapacidadMaxima()-caf.getCantidadActual())){
             caf.setCantidadActual(cantidad+caf.getCantidadActual());
             System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
             return caf;
         }else{
             System.out.println("La cantidad a ingresar "+cantidad+" supera la capacidad maxima");
             System.out.println("Solo se ingresa "+(caf.getCapacidadMaxima()-caf.getCantidadActual())+" ml");
             caf.setCantidadActual(caf.getCapacidadMaxima());
             System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
             return caf;
         }
    }
    
    public Cafetera servirTaza(int cantidadActual, Cafetera caf){
        int tam_taza;
        System.out.println("Ingrese el tamaño de la taza");
        tam_taza = sc.nextInt();
        if(cantidadActual>=tam_taza){
            cantidadActual-=tam_taza;
            caf.setCantidadActual(cantidadActual);
            System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
            return caf;
        }else{
            System.out.println("No se puede llenar la taza, solo se lleno con : "+cantidadActual+" ml");
            //caf.setCantidadActual(0);
            vaciarCafetera(caf);
            System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
            return caf;
        }
    }
    
    public void vaciarCafetera(Cafetera caf){
        caf.setCantidadActual(0);
        System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
    }
    
    public Cafetera agregarCafe(int cantidadActual, Cafetera caf){
        int cantidadAgregar;
        System.out.println("¿Cuanto cafe agregara a la cafetera?");
        cantidadAgregar = sc.nextInt();
        if((cantidadActual+cantidadAgregar)<=caf.getCapacidadMaxima()){
            caf.setCantidadActual(cantidadAgregar);
            System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
            return caf;
        }else{
            System.out.println("La cantidad supera la capacidad maxima, solo se agrego:"+ abs(cantidadAgregar-cantidadActual)+" ml");
            caf.setCantidadActual(caf.getCantidadActual()+abs(cantidadAgregar-cantidadActual));
            System.out.println("Cantidad Actual en la cafetera "+caf.getCantidadActual()+" ml");
            return caf;
        }
    }
    
}
