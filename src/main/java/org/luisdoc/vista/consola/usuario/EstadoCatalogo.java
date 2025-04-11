package org.luisdoc.vista.consola.usuario;
import org.luisdoc.jdbc.GenericJdbc;
import org.luisdoc.jdbc.impl.EstadoJdbcImpl;
import org.luisdoc.model.Estado;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.util.List;

public class EstadoCatalogo extends GestorCatalogos<Estado>
{
    private static EstadoCatalogo estadoCatalogo;
    private static final GenericJdbc<Estado> estadoJdbc = EstadoJdbcImpl.getInstance();

    public static EstadoCatalogo getInstance( )
    {
        if(estadoCatalogo==null)
        {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    private EstadoCatalogo( )
    {
        super(EstadoJdbcImpl.getInstance());
    }

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
        estadoJdbc.save(estado);
        return true;
    }

    @Override
    public void edit(Estado estado)
    {
        List<Estado> list = estadoJdbc.findAll();
        list.stream().forEach(System.out::println);
        System.out.print("> Ingrese el ID del estado a editar: ");
        estado.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo nombre del estado: ");
        estado.setNombre( ReadUtil.read() );

        estadoJdbc.update(estado);
    }
}


