import java.util.*;

public class main {
    private static LinkedList<Cancion> playList=new LinkedList<>();
    private static ListIterator<Cancion> playListIt;

    public static void main(String[] args) {
        ArrayList<Album> hits=new ArrayList<Album>();

        Album a1=new Album("muerte","canserbero");
        a1.addSong("llovia",4.5);
        a1.addSong("es epico",5.2);
        a1.addSong("el primer trago",4.4);

        Album a2=new Album("juglar del s.XXI","ayax");
        a2.addSong("la gondola",3.2);
        a2.addSong("la mili",3.3);
        a2.addSong("el leon",2.5);

        a1.addToPlayList(1,playList);
        a1.addToPlayList("es epico",playList);
        a1.addToPlayList(3,playList);

        a2.addToPlayList(1,playList);
        a2.addToPlayList("la mili",playList);
        a2.addToPlayList(3,playList);

        imprimirListaDeRep();
        playListIt=playList.listIterator();
        play();
    }

    public static void imprimirMenu(){
        System.out.println("0 – Salir de la lista de reproducción");
        System.out.println("1 – Reproducir siguiente canción en la lista");
        System.out.println("2 – Reproducir la canción previa de la lista");
        System.out.println("3 – Repetir la canción actual");
        System.out.println("4 – Imprimir la lista de canciones en la playlist");
        System.out.println("5 – Volver a imprimir el menú.");
        System.out.println("6 - Eliminar cancion");
    }

    public static void imprimirListaDeRep(){
        System.out.println("Lista de reproduccion");
        for (Cancion c:playList){
            System.out.println(c);
        }
    }

    public static void play(){
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        boolean continuar=true;
        boolean siguiente=true;
        imprimirMenu();

        while (continuar){
            try{
                System.out.println("Elige una opcion: ");
                opcion=sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    case 0:
                        System.out.println("Adios");
                        continuar=false;
                        break;
                    case 1:
                        if (!siguiente){
                            if (playListIt.hasNext())
                                playListIt.next();
                            siguiente=true;
                        }
                        if (playListIt.hasNext()){
                            System.out.println("Reproduciendo "+ playListIt.next());
                        } else {
                            System.out.println("Ya no hay mas canciones para reproducir en la lista");
                            siguiente=false;
                        }
                        break;
                    case 2:
                        if (siguiente){
                            if (playListIt.hasPrevious())
                                playListIt.previous();
                            siguiente=false;
                        }
                        if (playListIt.hasPrevious()){
                            System.out.println("Reproduciendo "+ playListIt.previous());
                        } else {
                            System.out.println("Ya no hay mas canciones para retroceder en la lista");
                            siguiente = true;
                        }
                        break;
                    case 3:
                        if (siguiente){
                            if (playListIt.hasPrevious()){
                                System.out.println("Reproduciendo "+ playListIt.previous());
                                playListIt.next();
                            }
                        } else {
                            if (playListIt.hasNext()){
                                System.out.println("Reproduciendo " + playListIt.next());
                                playListIt.previous();
                            }
                        }
                        break;
                    case 4:
                        imprimirListaDeRep();
                        break;
                    case 5:
                        imprimirMenu();
                        break;
                    case 6:
                        if (!siguiente){
                            if (playListIt.hasNext()){
                                playListIt.remove();
                            }
                        } else if (playListIt.hasPrevious()){
                                playListIt.remove();
                        } else {
                            System.out.println("No hay mas canciones para eliminar");
                    }
                        break;
                    default:
                        System.out.println("Introduzca una opcion valida");
                }
            }catch (InputMismatchException e){
                System.out.println("Introduzca un numero valido");
                sc.nextLine();
            }

        }
    }
}
