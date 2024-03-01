import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String nombre;
    private String artista;
    private List<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        canciones = new ArrayList<Cancion>();
    }

    private Cancion findSong(String titulo){
        for (Cancion c:canciones){
            if (c.getTitulo().equals(titulo)){
                return c;
            }
        }
        return null;
    }

    public boolean addSong(String titulo,double duracion){
        if (findSong(titulo)!=null){
            return false;
        }else {
            Cancion xd=new Cancion(titulo,duracion);
            canciones.add(xd);
            return true;
        }
    }
    public boolean addToPlayList(int numPista,LinkedList<Cancion> paco){
        int index=numPista-1;
        if (index>=0 && index< canciones.size()){
            Cancion tusilini=canciones.get(index);
            paco.add(tusilini);
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(String nombre,LinkedList<Cancion> pepe){
        Cancion joker=findSong(nombre);
        if (joker!=null){
            pepe.add(joker);
            return true;
        } else {
            return false;
        }
    }

}
