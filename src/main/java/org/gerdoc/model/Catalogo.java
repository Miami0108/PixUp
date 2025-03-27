package org.gerdoc.model;

public enum Catalogo {
    CATALOGO(1),
   PENDIENTE(2),
    SALIR(3),
    OPCION_ERRONEA(4);
    private Integer tipo;

    Catalogo(Integer tipo)
    {
        this.tipo = tipo;
    }

    public Integer getTipo()
    {
        return tipo;
    }

    public static Catalogo getCatalogoById( Integer id )
    {
        switch( id )
        {
            case 1:
                return CATALOGO;
            case 2:
                return PENDIENTE;
            case 3:
                return SALIR;
            default:
                return OPCION_ERRONEA;
        }
    }
}
