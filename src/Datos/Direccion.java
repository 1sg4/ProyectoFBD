/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Direccion
{
    private String idDireccion;
    private String calle;
    private int codigoPostal;
    private int noExterior;

    public Direccion()
    {
    }

    public Direccion(String idDireccion, String calle, int codigoPostal, int noExterior)
    {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.noExterior = noExterior;
    }

    public String getIdDireccion()
    {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion)
    {
        this.idDireccion = idDireccion;
    }

    public String getCalle()
    {
        return calle;
    }

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public int getCodigoPostal()
    {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }

    public int getNoExterior()
    {
        return noExterior;
    }

    public void setNoExterior(int noExterior)
    {
        this.noExterior = noExterior;
    }
    
    
}
