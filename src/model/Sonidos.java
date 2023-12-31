package model;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Joaquín
 */
public class Sonidos {
    
    File errorClave = new File("src//musica//ohno.mp3");
    String serrorClave = "file:///" + errorClave.getAbsolutePath();
    MediaPlayer mediaplayer;
    
    File inicio = new File("src//musica//gracias.mp3");
    String sinicio = "file:///" + inicio.getAbsolutePath();
    MediaPlayer mediaplayerInicio;
    
    File cartaPizzas = new File("src//musica//carta_pizzas.mp3");
    String scartaPizzas = "file:///" + cartaPizzas.getAbsolutePath();
    MediaPlayer mediaplayerCartaPizzas;
    
    public void SonidoError(){
        
        serrorClave = serrorClave.replace("\\", "/");
        
        Media musicError = new Media(serrorClave);
        mediaplayer = new MediaPlayer(musicError);
        mediaplayer.play();
        
    }
    
    public void InicioPrograma(){
        
        sinicio = sinicio.replace("\\", "/");
        
        Media musicinicio = new Media(sinicio);
        mediaplayerInicio = new MediaPlayer(musicinicio);
        mediaplayerInicio.play();
        
    }
    
    public void Carta_Pizzas(){
        
        scartaPizzas = scartaPizzas.replace("\\", "/");
        Media carta_Pizzas = new Media(scartaPizzas);
        mediaplayerCartaPizzas = new MediaPlayer(carta_Pizzas);
        mediaplayerCartaPizzas.play();
        
    }
    
}
