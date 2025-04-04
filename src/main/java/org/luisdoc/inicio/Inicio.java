package org.luisdoc.inicio;

import org.luisdoc.vista.SeleccionEjecutable;

public class Inicio
{
    public static void main(String[] args)
    {
        System.out.println("\t<:: PixUp ::>");
        SeleccionEjecutable.getInstance().run();
        System.out.println("\t¡Hasta pronto!");
    }
}

