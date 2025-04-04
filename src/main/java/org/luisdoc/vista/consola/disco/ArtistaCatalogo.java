package org.luisdoc.vista.consola.disco;

import org.luisdoc.model.Artista;
import org.luisdoc.model.Estado;
import org.luisdoc.util.ReadUtil;
import org.luisdoc.vista.consola.GestorCatalogos;

import java.io.File;

public class ArtistaCatalogo extends GestorCatalogos<Artista>
{
    private static ArtistaCatalogo artistaCatalogo;

    private ArtistaCatalogo()
    {
        super();
    }

    public static ArtistaCatalogo getInstance()
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT()
    {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista)
    {
        System.out.print("> Ingrese el nombre del artista: ");
        artista.setArtista( ReadUtil.read() );
        return true;
    }

    @Override
    public void processEditT(Artista artista)
    {
        System.out.println("\n> ID del artista siendo editado: "+artista.getId());
        System.out.println("> Nombre del artista siendo editado: "+artista.getArtista());
        System.out.print("> Ingrese el nuevo nombre del artista: ");
        artista.setArtista( ReadUtil.read() );
    }

    @Override
    public File getFile() {
        return new File("./src/main/fileStorage/Artistas.object");
    }

    public Artista getArtistaById() {
        if (isListaEmpty()) {
            System.out.println("> No hay artistas registrados.");
            return null;
        }
        while (true) {
            System.out.print("> Ingrese el ID del artista: ");
            int id = ReadUtil.readInt();
            Artista artista = list.stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (artista != null) {
                return artista;
            }
            System.out.println("> ID incorrecto, inténtelo nuevamente.");
        }
    }
}
