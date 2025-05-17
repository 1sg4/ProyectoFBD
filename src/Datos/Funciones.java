/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Funciones
{
    private String idFuncion;
    private String cvePelicula;
    private String idCineSalas;
    private Date fecha;
    private String hora;

    public Funciones()
    {
    }

    public Funciones(String idFuncion, String cvePelicula, String idCineSalas, Date fecha, String hora)
    {
        this.idFuncion = idFuncion;
        this.cvePelicula = cvePelicula;
        this.idCineSalas = idCineSalas;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getIdFuncion()
    {
        return idFuncion;
    }

    public void setIdFuncion(String idFuncion)
    {
        this.idFuncion = idFuncion;
    }

    public String getCvePelicula()
    {
        return cvePelicula;
    }

    public void setCvePelicula(String cvePelicula)
    {
        this.cvePelicula = cvePelicula;
    }

    public String getIdCineSalas()
    {
        return idCineSalas;
    }

    public void setIdCineSalas(String idCineSalas)
    {
        this.idCineSalas = idCineSalas;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

}
