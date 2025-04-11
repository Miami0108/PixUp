package org.luisdoc.inicio;

import org.luisdoc.vista.SeleccionEjecutable;

public class Inicio
{
    public static void main(String[] args)
    {
        System.out.println("!Bienvenido a PixUp¡");
        SeleccionEjecutable.getInstance().run();
        System.out.println("\t¡Hasta luego, gracias por utilizar PixUp");
    }
}