/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Localidad
{
    private int codigoPostal;
    private String ciudad; 
    private String colonia;
    private String estado;

    public Localidad()
    {
    }

    public Localidad(int codigoPostal, String ciudad, String colonia, String estado)
    {
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.estado = estado;
    }

    public int getCodigoPostal()
    {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public String getColonia()
    {
        return colonia;
    }

    public void setColonia(String colonia)
    {
        this.colonia = colonia;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    
    
}
