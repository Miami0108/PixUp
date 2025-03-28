package org.luisdoc.inicio;


import org.luisdoc.model.Colonia;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.Ejecutable;
import org.luisdoc.vista.Menu;
import org.luisdoc.model.TipoEjecutable;

public class Inicio {
    public static void main(String[] args)
    {
        boolean flag = true;
        int opcion = 0;
        TipoEjecutable tipoEjecutable = null;
        Ejecutable ejecutable = null;
        while( flag )
        {
            Menu.menuPrincipal( );
            Menu.menu2( );
            opcion = ReadUtil.readInt( );
            tipoEjecutable = TipoEjecutable.getTipoEjecutableById( opcion );
            if( TipoEjecutable.SALIR.equals( tipoEjecutable ) )
            {
                flag = false;
            }
            if( TipoEjecutable.OPCION_ERRONEA.equals( tipoEjecutable ) )
            {
                Menu.opcionInvalida( );
            }
            if( tipoEjecutable.getEjecutable( ) != null )
            {
                ejecutable = tipoEjecutable.getEjecutable( );
                ejecutable.run( );
            }
        }
    }
}
