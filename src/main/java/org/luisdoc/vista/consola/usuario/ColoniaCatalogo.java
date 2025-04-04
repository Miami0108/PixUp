package org.luisdoc.vista.consola.usuario;

import org.luisdoc.model.Colonia;
import org.luisdoc.model.Municipio;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.io.File;

public class ColoniaCatalogo extends GestorCatalogos<Colonia>
{
    private static ColoniaCatalogo coloniaCatalogo;
    private MunicipioCatalogo municipioCatalogo;

    public static ColoniaCatalogo getInstance( )
    {
        if(coloniaCatalogo==null)
        {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    private ColoniaCatalogo( )
    {
        super();
        municipioCatalogo = MunicipioCatalogo.getInstance();
    }

    @Override
    public Colonia newT()
    {
        return new Colonia();
    }

    @Override
    public boolean processNewT(Colonia colonia)
    {
        System.out.print("> Teclee el nombre de la colonia: ");
        colonia.setNombre( ReadUtil.read() );
        System.out.print("> Teclee el código postal de la colonia: ");
        colonia.setCp( ReadUtil.read() );
        Municipio municipio = municipioCatalogo.getMunicipioById();

        if(municipio==null)
        {
            return false;
        }
        colonia.setMunicipio(municipio);
        return true;
    }

    @Override
    public void processEditT(Colonia colonia)
    {
        System.out.println("\n> ID de la colonia siendo editada: "+colonia.getId());
        System.out.println("> Colonia siendo editada: "+colonia.getNombre());
        System.out.print("> Ingrese el nuevo nombre de la colonia: ");
        colonia.setNombre( ReadUtil.read() );
        System.out.print("> Ingrese el nuevo código postal de la colonia: ");
        colonia.setCp( ReadUtil.read() );

        Municipio municipio = municipioCatalogo.getMunicipioById();

        if(municipio==null)
        {
            System.out.println("> Estado no encontrado. No se pudo actualizar el estado del municipio, compruébelo e inténtelo de nuevo.");
        }
        else
        {
            colonia.setMunicipio(municipio);
        }
    }

    @Override
    public File getFile() {
        return new File("./src/main/fileStorage/Colonias.list" );
    }
}

