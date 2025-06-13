package org.luisdoc.sql.jdbcimpl;

import org.luisdoc.sql.GenericJdbc;
import org.luisdoc.model.Colonia;
import org.luisdoc.model.Municipio;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaJdbcImplTest
{

    @Test
    void getInstance()
    {
        assertNotNull(ColoniaJdbcImpl.getInstance());
    }

    @Test
    void findAll()
    {
        GenericJdbc<Colonia> coloniaJdbc = ColoniaJdbcImpl.getInstance();
        List<Colonia> list = coloniaJdbc.findAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        list.stream().forEach(System.out::println);
    }

    @Test
    void save()
    {
        GenericJdbc<Colonia> coloniaJdbc = ColoniaJdbcImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setNombre("Colonia 1");
        colonia.setCp("23124");

        Municipio municipio = new Municipio();
        municipio.setId(4);
        colonia.setMunicipio(municipio);

        assertTrue(coloniaJdbc.save(colonia));
    }

    @Test
    void update()
    {
        GenericJdbc<Colonia> coloniaJdbc = ColoniaJdbcImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setNombre("Colonia2");
        colonia.setId(1);

        assertTrue(coloniaJdbc.update(colonia));
    }

    @Test
    void delete()
    {
        GenericJdbc<Colonia> coloniaJdbc = ColoniaJdbcImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setId(1);

        assertTrue(coloniaJdbc.delete(colonia));
    }

    @Test
    void findById()
    {
        GenericJdbc<Colonia> coloniaJdbc = ColoniaJdbcImpl.getInstance();
        Colonia colonia = coloniaJdbc.findById(1);

        assertNotNull(colonia);
        assertEquals(1, colonia.getId());

        System.out.println(colonia.getNombre());
    }
}