package org.luisdoc.vista.consola.disco;

import org.luisdoc.model.Cancion;
import org.luisdoc.model.Disco;
import org.luisdoc.model.Disquera;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.io.File;

public class CancionCatalogo extends GestorCatalogos<Cancion>
{
    private static CancionCatalogo cancionCatalogo;

    private CancionCatalogo()
    {
        super();
    }

    public static CancionCatalogo getInstance()
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.print("> Ingrese el título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );
        System.out.print("> Ingrese la duración de la canción en minutos: ");
        cancion.setDuracion( ReadUtil.readDouble() );

        Disco disco = DiscoCatalogo.getInstance().getDiscoById();
        if(disco==null)
        {
            return false;
        }
        else
        {
            cancion.setDisco( disco );
        }

        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("> ID de la canción siendo editada: "+cancion.getId());
        System.out.println("> Canción siendo editada: "+cancion.getTituloCancion());
        System.out.print("> Ingrese el nuevo título de la canción: ");
        cancion.setTituloCancion( ReadUtil.read() );
        System.out.print("> Ingrese la nueva duración de la canción en minutos: ");
        cancion.setDuracion( ReadUtil.readDouble() );

        Disco disco = DiscoCatalogo.getInstance().getDiscoById();
        if(disco==null)
        {
            System.out.println("> Disco no encontrado. No se pudo actualizar; compruébelo e inténtelo de nuevo.");;
        }
        else
        {
            cancion.setDisco( disco );
        }
    }

    @Override
    public File getFile() {
        return new File( "./src/main/fileStorage/Canciones.object" );
    }
}
