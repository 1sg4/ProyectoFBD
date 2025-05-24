/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pelicula;

/**
 *
 * @author camac
 */
import Datos.Peliculas;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDatos {
    // Lista estática donde se almacenarán las películas registradas en memoria.
    private static List<Peliculas> movies = new ArrayList<>();
    
    public static void addMovie(Peliculas movie) {
        movies.add(movie);
    }
    
    public static List<Peliculas> getMovies() {
        return movies;
    }
}

