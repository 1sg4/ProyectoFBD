/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class TipoSala
{
    private String tipoSala;
    private int capacidad;

    public TipoSala()
    {
    }

    public TipoSala(String tipoSala, int capacidad)
    {
        this.tipoSala = tipoSala;
        this.capacidad = capacidad;
    }

    public String getTipoSala()
    {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala)
    {
        this.tipoSala = tipoSala;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

    public void setCapacidad(int capacidad)
    {
        this.capacidad = capacidad;
    }
    
    
}
