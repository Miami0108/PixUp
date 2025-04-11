package org.luisdoc.vista.consola.disco;
import org.luisdoc.jdbc.GenericJdbc;
import org.luisdoc.jdbc.impl.Genero_MusicalJdbcImpl;
import org.luisdoc.model.Genero_Musical;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.util.List;

public class GeneroMusicalCatalogo extends GestorCatalogos<Genero_Musical>
{
    private static GeneroMusicalCatalogo generoMusicalCatalogo;
    private static final GenericJdbc<Genero_Musical> genero_musicalJdbc = Genero_MusicalJdbcImpl.getInstance();

    private GeneroMusicalCatalogo()
    {
        super(Genero_MusicalJdbcImpl.getInstance());
    }

    public static GeneroMusicalCatalogo getInstance()
    {
        if(generoMusicalCatalogo==null)
        {
            generoMusicalCatalogo = new GeneroMusicalCatalogo();
        }
        return generoMusicalCatalogo;
    }

    @Override
    public Genero_Musical newT() {
        return new Genero_Musical();
    }

    @Override
    public boolean processNewT(Genero_Musical generoMusical)
    {
        System.out.print("> Ingrese el género musical: ");
        generoMusical.setGenero( ReadUtil.read() );
        genero_musicalJdbc.save(generoMusical);
        return true;
    }

    @Override
    public void edit(Genero_Musical generoMusical)
    {
        List<Genero_Musical> list = genero_musicalJdbc.findAll();
        list.stream().forEach(System.out::println);
        System.out.print("> Ingrese el ID del género musical a editar: ");
        generoMusical.setId( ReadUtil.readInt() );
        System.out.print("> Ingrese el nuevo nombre del género musical: ");
        generoMusical.setGenero( ReadUtil.read() );
        genero_musicalJdbc.update(generoMusical);
    }
}
