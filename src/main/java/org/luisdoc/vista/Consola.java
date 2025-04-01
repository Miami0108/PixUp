package org.luisdoc.vista;

import org.luisdoc.util.ReadUtil;

public class Consola implements Ejecutable {
    private static Consola consola;
    private Consola()
    {
    }

    public static Consola getInstance( )
    {
        if(consola==null)
        {
            return new Consola();
        }
        return consola;
    }

    @Override
    public void run( )
    {
        boolean flag = true;
        int opcion = 0;
        Catalogo catalogo = null;
        while( flag )
        {
            Menu.menuPrincipal( );
            Menu.menu2( );
            opcion = ReadUtil.readInt( );

            catalogo =Catalogo.getCatalogoById( opcion );

            if( Catalogo.SALIR.equals( catalogo ) )
            {
                flag = false;
            }
            if( Catalogo.OPCION_ERRONEA.equals( catalogo) )
            {
                Menu.opcionInvalida( );
            }
        }

    }

}
