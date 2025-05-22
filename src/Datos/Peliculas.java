/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.InputStream;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class Peliculas
{

    private String cvePelicula;
    private String nombrePelicula;
    private String fechaEstreno;
    private String idIdioma;
    private String idClasificacion;
    private String subtitulos;
    private String duracion;
    private String sinopsis;
    private String reparto;
    private String trailer; // posiblemente esto lo cambiemos, pero hay que investigar mas al respecto.
    private String fotoRepresentativa;

    public Peliculas()
    {
    }

    public Peliculas(String cvePelicula, String nombrePelicula, String fechaEstreno, String idIdioma, String idClasificacion, String subtitulos, String duracion, String sinopsis, String reparto, String trailer, String fotoRepresentativa)
    {
        this.cvePelicula = cvePelicula;
        this.nombrePelicula = nombrePelicula;
        this.fechaEstreno = fechaEstreno;
        this.idIdioma = idIdioma;
        this.idClasificacion = idClasificacion;
        this.subtitulos = subtitulos;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.trailer = trailer;
        this.fotoRepresentativa = fotoRepresentativa;
    }

    public String getCvePelicula()
    {
        return cvePelicula;
    }

    public void setCvePelicula(String cvePelicula)
    {
        this.cvePelicula = cvePelicula;
    }

    public String getNombrePelicula()
    {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula)
    {
        this.nombrePelicula = nombrePelicula;
    }

    public String getFechaEstreno()
    {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno)
    {
        this.fechaEstreno = fechaEstreno;
    }

    public String getIdIdioma()
    {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma)
    {
        this.idIdioma = idIdioma;
    }

    public String getIdClasificacion()
    {
        return idClasificacion;
    }

    public void setIdClasificacion(String idClasificacion)
    {
        this.idClasificacion = idClasificacion;
    }

    public String getSubtitulos()
    {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos)
    {
        this.subtitulos = subtitulos;
    }

    public String getDuracion()
    {
        return duracion;
    }

    public void setDuracion(String duracion)
    {
        this.duracion = duracion;
    }

    public String getSinopsis()
    {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }

    public String getReparto()
    {
        return reparto;
    }

    public void setReparto(String reparto)
    {
        this.reparto = reparto;
    }

    public String getTrailer()
    {
        return trailer;
    }

    public void setTrailer(String trailer)
    {
        this.trailer = trailer;
    }

    public String getFotoRepresentativa()
    {
        return fotoRepresentativa;
    }

    public void setFotoRepresentativa(String fotoRepresentativa)
    {
        this.fotoRepresentativa = fotoRepresentativa;
    }


    @Override
    public String toString()
    {
        return "Clave: " + cvePelicula
                + ", Nombre: " + nombrePelicula
                + ", Fecha: " + fechaEstreno
                + ", Idioma: " + idIdioma
                + "Id clasificaion: " + idClasificacion
                + "sSubtitulos: " + subtitulos
                + "Duracion: " + duracion
                + "Sipnosis: " + sinopsis
                + "Reparto: " + reparto
                + "Trailer: " + trailer;
    }

}
