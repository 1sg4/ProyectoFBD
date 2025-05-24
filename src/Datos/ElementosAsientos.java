/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class ElementosAsientos
{
    private String idAsientoFuncion;
    private String noAsiento;
    private String idFuncion;
    private String disponibilidad;
    private String noBoleto;
    

    public ElementosAsientos()
    {
    }

    public ElementosAsientos(String idAsientoFuncion, String noAsiento, String idFuncion, String disponibilidad, String noBoleto)
    {
        this.idAsientoFuncion = idAsientoFuncion;
        this.noAsiento = noAsiento;
        this.idFuncion = idFuncion;
        this.disponibilidad = disponibilidad;
        this.noBoleto = noBoleto;
    }

    public String getIdAsientoFuncion()
    {
        return idAsientoFuncion;
    }

    public void setIdAsientoFuncion(String idAsientoFuncion)
    {
        this.idAsientoFuncion = idAsientoFuncion;
    }

    public String getNoAsiento()
    {
        return noAsiento;
    }

    public void setNoAsiento(String noAsiento)
    {
        this.noAsiento = noAsiento;
    }

    public String getIdFuncion()
    {
        return idFuncion;
    }

    public void setIdFuncion(String idFuncion)
    {
        this.idFuncion = idFuncion;
    }

    public String getDisponibilidad()
    {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad)
    {
        this.disponibilidad = disponibilidad;
    }

    public String getNoBoleto()
    {
        return noBoleto;
    }

    public void setNoBoleto(String noBoleto)
    {
        this.noBoleto = noBoleto;
    }

    
}
