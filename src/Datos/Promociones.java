/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Promociones
{
    private String cvePromocion;
    private String idCine;
    private String nombrePromocion;
    private String descuento;
    private String dia;

    public Promociones()
    {
    }

    public Promociones(String cvePromocion, String idCine, String nombrePromocion, String descuento, String dia)
    {
        this.cvePromocion = cvePromocion;
        this.idCine = idCine;
        this.nombrePromocion = nombrePromocion;
        this.descuento = descuento;
        this.dia = dia;
    }

    public String getCvePromocion()
    {
        return cvePromocion;
    }

    public void setCvePromocion(String cvePromocion)
    {
        this.cvePromocion = cvePromocion;
    }

    public String getIdCine()
    {
        return idCine;
    }

    public void setIdCine(String idCine)
    {
        this.idCine = idCine;
    }

    public String getNombrePromocion()
    {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion)
    {
        this.nombrePromocion = nombrePromocion;
    }

    public String getDescuento()
    {
        return descuento;
    }

    public void setDescuento(String descuento)
    {
        this.descuento = descuento;
    }

    public String getDia()
    {
        return dia;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
    }
    
    
}
