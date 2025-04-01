package org.luisdoc.gui.consola;

import org.luisdoc.model.Artista;
import org.luisdoc.model.Catalogo;
import org.luisdoc.util.ReadUtil;
import java.io.File;

public class ArtistaCatalogo extends Catalogos<Artista> {

    private static ArtistaCatalogo artistaCatalogo;
    private ArtistaCatalogo( ){
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Ingrese el nombre de un artista");
        artista.setArtista(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("ID del artista: " + artista.getId());
        System.out.println("El nombre del artista es: " + artista.getArtista( ));
        System.out.println("Escribe el nuevo nombre del artista");
        artista.setArtista(ReadUtil.read());
    }

    @Override
    public File getFile() {
        return null;
    }

}
