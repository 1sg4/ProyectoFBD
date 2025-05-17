/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class CineSalas
{
    private String idCineSalas;
    private String idCine;
    private int noSala;

    public CineSalas()
    {
    }

    public CineSalas(String idCineSalas, String idCine, int noSala)
    {
        this.idCineSalas = idCineSalas;
        this.idCine = idCine;
        this.noSala = noSala;
    }

    public String getIdCineSalas()
    {
        return idCineSalas;
    }

    public void setIdCineSalas(String idCineSalas)
    {
        this.idCineSalas = idCineSalas;
    }

    public String getIdCine()
    {
        return idCine;
    }

    public void setIdCine(String idCine)
    {
        this.idCine = idCine;
    }

    public int getNoSala()
    {
        return noSala;
    }

    public void setNoSala(int noSala)
    {
        this.noSala = noSala;
    }
    
    
}
