package org.luisdoc.vista;
import javax.swing.*;
public class Ventana extends JFrame implements Ejecutable{

    private static Ventana ventana;

    public static Ventana getInstance(){
        if(ventana==null)
        {
            ventana=new Ventana();
        }
        return ventana;
    }

    private Ventana( )
    {
        super( "Programa de figuras" );
    }

    @Override
    public void run()
    {
        setBounds( 100, 100, 300, 200);
        setVisible( true );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

}
