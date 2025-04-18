package org.luisdoc.vista.consola.usuario;

import org.luisdoc.model.Estado;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.io.File;

public class EstadoCatalogo extends GestorCatalogos<Estado>
{
    private static EstadoCatalogo estadoCatalogo;

    public static EstadoCatalogo getInstance( )
    {
        if(estadoCatalogo==null)
        {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    private EstadoCatalogo( ){ super(); }

    @Override
    public Estado newT()
    {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado)
    {
        System.out.print("> Teclee el nombre del estado: ");
        estado.setNombre( ReadUtil.read() );
        return true;
    }

    @Override
    public void processEditT(Estado estado)
    {
        System.out.println("\n> ID del estado siendo editado: "+estado.getId());
        System.out.println("> Estado siendo editado: "+estado.getNombre());
        System.out.print("> Ingrese el nuevo nombre del estado: ");
        estado.setNombre( ReadUtil.read() );
    }

    @Override
    public File getFile()
    {
        return new File("./src/main/fileStorage/Estados.object" );
    }

    public Estado getEstadoById() {
        if (isListaEmpty()) {
            System.out.println("> No hay estados registrados.");
            return null;
        }
        while (true) {
            System.out.print("> Ingrese el ID del estado: ");
            int id = ReadUtil.readInt();
            Estado estado = list.stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (estado != null) {
                return estado;
            }
            System.out.println("> ID incorrecto, inténtelo nuevamente.");
        }
    }

}


