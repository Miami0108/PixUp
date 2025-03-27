package org.gerdoc.vista;

public class Menu {

    public static void menuPrincipal(){
        System.out.println("Bienvenido a PixUp");
        System.out.println("Seleccione una opción");
        System.out.println("1.- Consola");
        System.out.println("2.- Ventana");
    }

    public static void menu2(){
        System.out.println("Ingrese la opción");
        System.out.println("1.- Catálogo");
        System.out.println("2.- Pendiente");
        System.out.println("3.- Salir");
    }

    public static void opcionInvalida( )
    {
        System.out.println("La opción no es correcta");
    }

    public static void errorDato(){
        System.out.println("No es un dato válido");
    }
}
