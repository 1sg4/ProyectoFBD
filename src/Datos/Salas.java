/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Salas
{
    private int noSala;
    private String tipoSala;

    public Salas()
    {
    }

    public Salas(int noSala, String tipoSala)
    {
        this.noSala = noSala;
        this.tipoSala = tipoSala;
    }

    public int getNoSala()
    {
        return noSala;
    }

    public void setNoSala(int noSala)
    {
        this.noSala = noSala;
    }

    public String getTipoSala()
    {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala)
    {
        this.tipoSala = tipoSala;
    }
    
    
}
