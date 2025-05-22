/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Cines
{

    private String idCine;
    private String nombreCine;
    private String idDireccion;

    public Cines()
    {
    }

    public Cines(String idCine, String nombreCine, String idDireccion)
    {
        this.idCine = idCine;
        this.nombreCine = nombreCine;
        this.idDireccion = idDireccion;
    }

    public String getIdCine()
    {
        return idCine;
    }

    public void setIdCine(String idCine)
    {
        this.idCine = idCine;
    }

    public String getNombreCine()
    {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine)
    {
        this.nombreCine = nombreCine;
    }

    public String getIdDireccion()
    {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion)
    {
        this.idDireccion = idDireccion;
    }

    @Override
    public String toString()
    {
        return this.nombreCine; // Solo se muestra esto en el JComboBox
    }

}
