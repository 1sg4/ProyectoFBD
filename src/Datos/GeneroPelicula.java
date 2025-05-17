/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class GeneroPelicula
{
    private String cvePelicula;
    private String cveGenero;

    public GeneroPelicula()
    {
    }

    public GeneroPelicula(String cvePelicula, String cveGenero)
    {
        this.cvePelicula = cvePelicula;
        this.cveGenero = cveGenero;
    }

    public String getCvePelicula()
    {
        return cvePelicula;
    }

    public void setCvePelicula(String cvePelicula)
    {
        this.cvePelicula = cvePelicula;
    }

    public String getCveGenero()
    {
        return cveGenero;
    }

    public void setCveGenero(String cveGenero)
    {
        this.cveGenero = cveGenero;
    }
    
    
}
