/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Genero
{
    private String cveGenero;
    private String nombreGenero;

    public Genero()
    {
    }

    public Genero(String cveGenero, String nombreGenero)
    {
        this.cveGenero = cveGenero;
        this.nombreGenero = nombreGenero;
    }

    public String getCveGenero()
    {
        return cveGenero;
    }

    public void setCveGenero(String cveGenero)
    {
        this.cveGenero = cveGenero;
    }

    public String getNombreGenero()
    {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero)
    {
        this.nombreGenero = nombreGenero;
    }
    
    
}
